package pl.javorek.ddd.service.applicationforloan.application.readmodel;

import lombok.Builder;
import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.eventlistener.DomainEventListener;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationStatusType;

@Component
@Builder
public class LoanApplicationStateProjector implements DomainEventListener {
    @Override
    public void onDomainEvent(DomainEvent event, ApplicationForALoanState state) {
        if (event instanceof DomainEvent.LoanRequested loanRequested) {
            accept(loanRequested, state);
        }
    }

    private void accept(DomainEvent.LoanRequested loanRequested, ApplicationForALoanState state) {
        state.setApplicationNumber(loanRequested.applicationNumber());
        state.setApplicationStatus(ApplicationStatusType.DRAFT);
    }
}
