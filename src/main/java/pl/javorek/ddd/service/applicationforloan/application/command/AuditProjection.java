package pl.javorek.ddd.service.applicationforloan.application.command;

import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent;

@Component
public class AuditProjection implements DomainEventListener {
    @Override
    public void onDomainEvent(DomainEvent event, ApplicationForALoanEntity state) {

    }
}
