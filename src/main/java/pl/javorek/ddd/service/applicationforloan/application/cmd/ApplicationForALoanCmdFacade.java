package pl.javorek.ddd.service.applicationforloan.application.cmd;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javorek.ddd.service.applicationforloan.application.eventlistener.DomainEventListenerComposite;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanStateRepository;
import pl.javorek.ddd.service.applicationforloan.domain.ApplicationForALoan;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.LoanRequestor;

import java.util.UUID;

@Service
@Transactional
@Builder
@RequiredArgsConstructor
public class ApplicationForALoanCmdFacade {
    private final ApplicationForALoanStateRepository applicationForALoanStateRepository;
    private final DomainEventListenerComposite domainEventListenerComposite;
    private final AttachedDocumentMapper attachedDocumentMapper;
    private final ApplicationForALoanMapper applicationForALoanMapper;

    public UUID submitLoanApplication(SubmitLoanApplicationCmd cmd) {
        var loanRequestor = LoanRequestor.builder()
                .name(cmd.name())
                .lastName(cmd.lastName())
                .build();
        var event = ApplicationForALoan.requestForLoan(loanRequestor);

        var state = applicationForALoanStateRepository.save(event);

        domainEventListenerComposite.onDomainEvent(event, state);

        return state.getId();
    }

    public void provideRequiredDocuments(ProvideRequiredDocumentCmd cmd) {
        var state = applicationForALoanStateRepository.findOneById(cmd.id())
                .orElseThrow();

        state.addDocument(attachedDocumentMapper.map(cmd));
    }

    public void sendRequestForLoanStart(SendRequestForLoanStartCmd cmd) {
        var state = applicationForALoanStateRepository.findOneById(cmd.id())
                .orElseThrow();

        var applicationForALoan = applicationForALoanMapper.map(state);
        var event = applicationForALoan.sendRequestForLoanStart();
        applicationForALoanStateRepository.save(state, event);
    }
}
