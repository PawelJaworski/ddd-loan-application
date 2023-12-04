package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.kafka;

import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.KafkaOutbox;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.KafkaOutboxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class KafkaOutboxInMemoryRepository implements KafkaOutboxRepository {
    private final Map<UUID, KafkaOutbox> data = new HashMap<>();

    @Override
    public KafkaOutbox save(KafkaOutbox entity) {
        return data.put(entity.getId(), entity);
    }

    @Override
    public Optional<KafkaOutbox> findById(UUID id) {
        return Optional.ofNullable(data.get(id));
    }

    public void deleteAll() {
        data.clear();
    }
}
