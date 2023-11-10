package pl.javorek.ddd.service.applicationforloan.application.event;

import pl.javorek.ddd.service.applicationforloan.application.readmodel.LoanApplicationState;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;

public interface DomainEventListener {
    void onDomainEvent(DomainEvent event, LoanApplicationState state);
}
