package pl.javorek.ddd.service.applicationforloan.application.outbound;

import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.eventlistener.DomainEventListener;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanState;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;

import java.util.UUID;

@Component
public class EmailPublisher implements DomainEventListener {

    @Override
    public void onDomainEvent(DomainEvent event, ApplicationForALoanState state) {

    }
}
