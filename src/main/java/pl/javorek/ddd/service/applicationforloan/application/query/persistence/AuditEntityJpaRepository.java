package pl.javorek.ddd.service.applicationforloan.application.query.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javorek.ddd.service.applicationforloan.application.query.persistence.AuditEntity;
import pl.javorek.ddd.service.applicationforloan.application.query.persistence.AuditEntityRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuditEntityJpaRepository extends AuditEntityRepository, JpaRepository<AuditEntity, UUID> {

    @Override
    Optional<AuditEntity> findById(UUID id);
}
