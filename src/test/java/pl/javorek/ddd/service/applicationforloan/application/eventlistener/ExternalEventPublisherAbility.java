package pl.javorek.ddd.service.applicationforloan.application.eventlistener;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.ExternalEventPublisher;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.kafka.KafkaOutboxRepositoryAbility;


public interface ExternalEventPublisherAbility {
    ExternalEventPublisher INSTANCE = ExternalEventPublisher.builder()
            .kafkaOutboxRepository(KafkaOutboxRepositoryAbility.INSTANCE)
            .objectMapper(new ObjectMapper())
            .build();

    default ExternalEventPublisher getExternalEventPublisher() {
        return INSTANCE;
    }
}