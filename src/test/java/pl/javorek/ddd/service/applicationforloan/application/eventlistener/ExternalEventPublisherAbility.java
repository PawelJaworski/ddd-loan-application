package pl.javorek.ddd.service.applicationforloan.application.eventlistener;

import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.kafka.ExternalEventKafkaPublisher;

public interface ExternalEventPublisherAbility {
    ExternalEventKafkaPublisher INSTANCE = ExternalEventKafkaPublisher.builder().build();

    default ExternalEventKafkaPublisher getExternalEventPublisher() {
        return INSTANCE;
    }
}