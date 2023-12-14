package pl.javorek.ddd.service.applicationforloan.application.persistence;

import java.util.Optional;
import java.util.UUID;

public interface EventStoreEntityRepository {
    EventStoreEntity save(EventStoreEntity entity);
    Optional<EventStoreEntity> findById(UUID id);
}
