package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms.persistence;

import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms.persistence.SmsOutbox;

import java.util.Optional;
import java.util.UUID;

public interface SmsOutboxRepository {
     SmsOutbox save(SmsOutbox entity);

    Optional<SmsOutbox> findById(UUID id);

    void deleteAll();
}
