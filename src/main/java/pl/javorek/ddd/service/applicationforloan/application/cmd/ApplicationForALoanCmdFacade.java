package pl.javorek.ddd.service.applicationforloan.application.cmd;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javorek.ddd.service.applicationforloan.application.eventlistener.DomainEventListenerComposite;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanState;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanStateRepository;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanStateProjector;
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
    private final ApplicationForALoanStateProjector applicationForALoanStateProjector;


    public UUID requestForLoan(RequestForALoanCmd cmd) {
        var loanRequestor = new LoanRequestor();
        var event = ApplicationForALoan.requestForLoan(loanRequestor);

        var state = applicationForALoanStateProjector.accept(event, new ApplicationForALoanState(event.id()));
        domainEventListenerComposite.onDomainEvent(event, state);


        return event.id();
    }
}
