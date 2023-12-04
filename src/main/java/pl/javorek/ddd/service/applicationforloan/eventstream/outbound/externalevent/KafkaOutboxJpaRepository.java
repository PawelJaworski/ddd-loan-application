package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KafkaOutboxJpaRepository extends KafkaOutboxRepository, JpaRepository<KafkaOutbox, UUID> {
}
