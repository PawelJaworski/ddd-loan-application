package pl.javorek.ddd.service.applicationforloan.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javorek.ddd.service.applicationforloan.application.persistence.AuditEntity;
import pl.javorek.ddd.service.applicationforloan.application.persistence.AuditEntityRepository;
import pl.javorek.ddd.service.applicationforloan.application.persistence.EventStoreEntity;
import pl.javorek.ddd.service.applicationforloan.application.persistence.EventStoreEntityRepository;

import java.util.Optional;
import java.util.UUID;

public interface EventStoreEntityJpaRepository extends EventStoreEntityRepository, JpaRepository<EventStoreEntity, UUID> {
}
