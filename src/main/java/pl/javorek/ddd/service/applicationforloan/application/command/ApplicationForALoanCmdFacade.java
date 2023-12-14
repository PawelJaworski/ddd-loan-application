package pl.javorek.ddd.service.applicationforloan.application.command;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javorek.ddd.service.applicationforloan.application.command.dto.ProvideRequiredDocumentCmd;
import pl.javorek.ddd.service.applicationforloan.application.command.dto.SendCommunicationAboutStartedLoanCmd;
import pl.javorek.ddd.service.applicationforloan.application.command.dto.SendRequestForLoanStartCmd;
import pl.javorek.ddd.service.applicationforloan.application.command.dto.SubmitLoanApplicationCmd;
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntityRepository;
import pl.javorek.ddd.service.applicationforloan.application.persistence.EventStoreEntity;
import pl.javorek.ddd.service.applicationforloan.application.persistence.EventStoreEntityRepository;
import pl.javorek.ddd.service.applicationforloan.domain.ApplicationForALoan;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@Builder
@RequiredArgsConstructor
public class ApplicationForALoanCmdFacade {
    private final ApplicationForALoanEntityRepository applicationForALoanEntityRepository;
    private final DomainEventListenerComposite domainEventListenerComposite;
    private final DomainFactory domainFactory;
    private final EventStoreEntityRepository eventStoreEntityRepository;

    public UUID submitLoanApplication(SubmitLoanApplicationCmd cmd) {
        var event = domainFactory.newApplicationForALoan()
                .requestForLoan(domainFactory.newLoanRequestor(cmd), domainFactory.newCommunicationAgreements(cmd));
        var state = applicationForALoanEntityRepository.save(event);

        domainEventListenerComposite.onDomainEvent(event, state);
        var eventStore = eventStoreEntityRepository.save(new EventStoreEntity(state.getId()));
        eventStore.addEvent(event);

        return state.getId();
    }

    public void provideRequiredDocuments(ProvideRequiredDocumentCmd cmd) {
        var attachedDocument = domainFactory.newAttachedDocument(cmd);
        applicationForALoanEntityRepository
                .findOneById(cmd.id())
                .ifPresent(event -> applicationForALoanEntityRepository.save(event, attachedDocument));
    }

    public void sendRequestForLoanStart(SendRequestForLoanStartCmd cmd) {
        var state = applicationForALoanEntityRepository.findOneById(cmd.id())
                .orElseThrow();

        var event = Optional.ofNullable(domainFactory.newApplicationForALoan(state))
                .map(ApplicationForALoan::sendRequestForLoanStart)
                .orElseThrow();
        eventStoreEntityRepository.findById(cmd.id())
                .ifPresent(eventStoreEntityRepository::save);
        applicationForALoanEntityRepository.save(state, event);
    }

    public void sendCommunicationAboutStartedLoan(SendCommunicationAboutStartedLoanCmd cmd) {
        var state = applicationForALoanEntityRepository.findOneByApplicationNumberAsString(cmd.applicationNumber())
                .orElseThrow();

        var event = Optional.ofNullable(domainFactory.newApplicationForALoan(state))
                .map(ApplicationForALoan::sendClientCommunicationForStartedLoan)
                .orElseThrow();

        domainEventListenerComposite.onDomainEvent(event, state);
    }
}
