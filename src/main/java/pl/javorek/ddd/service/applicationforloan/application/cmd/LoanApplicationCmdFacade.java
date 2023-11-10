package pl.javorek.ddd.service.applicationforloan.application.cmd;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javorek.ddd.service.applicationforloan.application.event.DomainEventListenerComposite;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.LoanApplicationState;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.LoanApplicationStateProjector;
import pl.javorek.ddd.service.applicationforloan.domain.ApplicationForALoan;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.LoanRequestor;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class LoanApplicationCmdFacade {
    private final LoanApplicationStateProjector loanApplicationStateProjector;
    private final DomainEventListenerComposite domainEventListenerComposite;


    public UUID requestForLoan(RequestForLoanCmd cmd) {
        var loanRequestor = new LoanRequestor();
        var event = ApplicationForALoan.requestForLoan(loanRequestor);

        var request = new LoanApplicationState(event.id());
        domainEventListenerComposite.onDomainEvent(event, request);

        return event.id();
    }
}
