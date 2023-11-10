package pl.javorek.ddd.service.applicationforloan.application.readmodel;

import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.event.DomainEventListener;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;

@Component
public class LoanApplicationStateProjector implements DomainEventListener {


    @Override
    public void onDomainEvent(DomainEvent event, LoanApplicationState state) {
        if (event instanceof DomainEvent.LoanRequested loanRequested) {
            accept(loanRequested, state);
        }
    }

    private void accept(DomainEvent.LoanRequested loanRequested, LoanApplicationState state) {
        state.setApplicationNumber(loanRequested.applicationNumber());
        loanRequested.loanRequestor();
    }
}
