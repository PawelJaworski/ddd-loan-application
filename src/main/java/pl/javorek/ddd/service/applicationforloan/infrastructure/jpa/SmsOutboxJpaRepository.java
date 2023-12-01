package pl.javorek.ddd.service.applicationforloan.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms.SmsOutbox;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms.SmsOutboxRepository;

import java.util.UUID;

public interface SmsOutboxJpaRepository extends SmsOutboxRepository, JpaRepository<SmsOutbox, UUID> {
}
