package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.kafka;

import lombok.Builder;
import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.command.DomainEventListener;
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent;

@Component
@Builder
public class ExternalEventKafkaPublisher implements DomainEventListener {

    @Override
    public void onDomainEvent(DomainEvent event, ApplicationForALoanEntity state) {

    }
}
