package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface SmsOutboxJpaRepository extends SmsOutboxRepository, JpaRepository<SmsOutbox, UUID> {
}
