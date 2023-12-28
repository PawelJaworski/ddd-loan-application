package pl.javorek.ddd.service.applicationforloan.application.persistence;

import pl.javorek.ddd.service.applicationforloan.application.command.persistence.EventStoreEntity;
import pl.javorek.ddd.service.applicationforloan.application.command.persistence.EventStoreEntityRepository;

import java.util.*;

public class EventStoreEntityInMemoryRepository implements EventStoreEntityRepository {
    private final Map<UUID, EventStoreEntity> data = new HashMap<>();

    @Override
    public EventStoreEntity save(EventStoreEntity entity) {
        data.put(entity.getId(), entity);

        return entity;
    }

    @Override
    public Optional<EventStoreEntity> findById(UUID id) {
        return Optional.ofNullable(data.get(id));
    }

    public void deleteAll() {
        data.clear();
    }
}
