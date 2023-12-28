package pl.javorek.ddd.service.applicationforloan.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javorek.ddd.service.applicationforloan.application.persistence.EventStoreEntity;
import pl.javorek.ddd.service.applicationforloan.application.persistence.EventStoreEntityRepository;

import java.util.UUID;

public interface EventStoreEntityJpaRepository extends EventStoreEntityRepository, JpaRepository<EventStoreEntity, UUID> {
}
