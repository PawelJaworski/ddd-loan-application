package pl.javorek.ddd.service.applicationforloan.application.eventlistener;

import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanState;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;

public interface DomainEventListener {
    void onDomainEvent(DomainEvent event, ApplicationForALoanState state);
}
