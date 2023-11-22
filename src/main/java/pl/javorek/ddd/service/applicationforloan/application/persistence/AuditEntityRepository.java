package pl.javorek.ddd.service.applicationforloan.application.persistence;

import java.util.Optional;
import java.util.UUID;

public interface AuditEntityRepository {
    AuditEntity save(AuditEntity entity);
    Optional<AuditEntity> findById(UUID id);
}
