package pl.javorek.ddd.service.applicationforloan.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javorek.ddd.service.applicationforloan.application.persistence.AuditEntity;
import pl.javorek.ddd.service.applicationforloan.application.persistence.AuditEntityRepository;

import java.util.Optional;
import java.util.UUID;

public interface AuditEntityJpaRepository extends AuditEntityRepository, JpaRepository<AuditEntity, UUID> {

    @Override
    AuditEntity save(AuditEntity entity);

    @Override
    Optional<AuditEntity> findOneById(UUID id);
}
