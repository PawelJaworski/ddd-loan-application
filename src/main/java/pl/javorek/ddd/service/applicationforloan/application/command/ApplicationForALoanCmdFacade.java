package pl.javorek.ddd.service.applicationforloan.application.command;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javorek.ddd.service.applicationforloan.application.eventlistener.DomainEventListenerComposite;
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanStateRepository;
import pl.javorek.ddd.service.applicationforloan.domain.ApplicationForALoan;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@Builder
@RequiredArgsConstructor
public class ApplicationForALoanCmdFacade {
    private final ApplicationForALoanStateRepository applicationForALoanStateRepository;
    private final DomainEventListenerComposite domainEventListenerComposite;
    private final DomainFactory domainFactory;

    public UUID submitLoanApplication(SubmitLoanApplicationCmd cmd) {
        var event = domainFactory.newApplicationForALoan()
                .requestForLoan(domainFactory.newLoanRequestor(cmd));
        var state = applicationForALoanStateRepository.save(event);

        domainEventListenerComposite.onDomainEvent(event, state);

        return state.getId();
    }

    public void provideRequiredDocuments(ProvideRequiredDocumentCmd cmd) {
        applicationForALoanStateRepository
                .findOneById(cmd.id())
                .ifPresent(it -> applicationForALoanStateRepository.save(it, domainFactory.newAttachedDocument(cmd)));
    }

    public void sendRequestForLoanStart(SendRequestForLoanStartCmd cmd) {
        var state = applicationForALoanStateRepository.findOneById(cmd.id())
                .orElseThrow();

        var event = Optional.ofNullable(domainFactory.newApplicationForALoan(state))
                .map(ApplicationForALoan::sendRequestForLoanStart)
                .orElseThrow();
        applicationForALoanStateRepository.save(state, event);
    }
}
