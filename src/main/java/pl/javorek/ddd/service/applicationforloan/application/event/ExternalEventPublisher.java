package pl.javorek.ddd.service.applicationforloan.application.event;

import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.LoanApplicationState;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;

@Component
public class ExternalEventPublisher implements DomainEventListener {

    @Override
    public void onDomainEvent(DomainEvent event, LoanApplicationState state) {

    }
}
