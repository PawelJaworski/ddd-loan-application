package pl.javorek.ddd.service.applicationforloan.application.command;

import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;

public interface DomainEventListener {
    void onDomainEvent(DomainEvent event, ApplicationForALoanEntity state);
}
