package pl.javorek.ddd.service.applicationforloan.application.command;

import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent;

public interface DomainEventListenerComposite extends DomainEventListener {
    void onDomainEvent(DomainEvent event, ApplicationForALoanEntity state);
}
