package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms;

import org.junit.jupiter.api.Assertions;

import java.util.Optional;
import java.util.UUID;

public interface SmsOutboxRepositoryAbility {
    SmsOutboxRepository INSTANCE = new SmsOutboxInMemoryRepository();

    default SmsOutboxRepository getSmsOutboxRepository() {
        return INSTANCE;
    }

    default Optional<SmsOutbox> with_sms_sent(UUID id) {
      return getSmsOutboxRepository().findById(id);
    }

}