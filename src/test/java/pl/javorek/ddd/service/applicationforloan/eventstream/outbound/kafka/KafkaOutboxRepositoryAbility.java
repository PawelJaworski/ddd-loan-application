package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.kafka;

import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.KafkaOutbox;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.KafkaOutboxRepository;

import java.util.Optional;
import java.util.UUID;

public interface KafkaOutboxRepositoryAbility {
    KafkaOutboxRepository INSTANCE = new KafkaOutboxInMemoryRepository();

    default KafkaOutboxRepository getKafkaOutboxRepository() {
        return INSTANCE;
    }

    default Optional<KafkaOutbox> with_kafka_sent(UUID id) {
      return getKafkaOutboxRepository().findById(id);
    }

}