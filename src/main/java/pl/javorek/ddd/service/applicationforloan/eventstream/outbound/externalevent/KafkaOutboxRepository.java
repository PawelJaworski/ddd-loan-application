package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent;

import java.util.Optional;
import java.util.UUID;

public interface KafkaOutboxRepository {
    KafkaOutbox save(KafkaOutbox entity);

    Optional<KafkaOutbox> findById(UUID id);

    void deleteAll();
}
