package pl.javorek.ddd.service.applicationforloan.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javorek.ddd.service.applicationforloan.application.persistence.AuditEntity;
import pl.javorek.ddd.service.applicationforloan.application.persistence.AuditEntityRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuditEntityJpaRepository extends AuditEntityRepository, JpaRepository<AuditEntity, UUID> {

    @Override
    Optional<AuditEntity> findById(UUID id);
}
