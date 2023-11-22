package pl.javorek.ddd.service.applicationforloan.application.persistence;

import java.util.*;

public class AuditEntityInMemoryRepository implements AuditEntityRepository {
    private final Map<UUID, AuditEntity> data = new HashMap<>();

    @Override
    public AuditEntity save(AuditEntity entity) {
        return data.put(entity.getId(), entity);
    }

    @Override
    public Optional<AuditEntity> findById(UUID id) {
        return Optional.ofNullable(data.get(id));
    }

    public void deleteAll() {
        data.clear();
    }
}
