package pl.javorek.ddd.service.applicationforloan.application.eventlistener;

import lombok.Builder;
import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanState;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;

@Component
@Builder
public class ExternalEventPublisher implements DomainEventListener {

    @Override
    public void onDomainEvent(DomainEvent event, ApplicationForALoanState state) {

    }
}
