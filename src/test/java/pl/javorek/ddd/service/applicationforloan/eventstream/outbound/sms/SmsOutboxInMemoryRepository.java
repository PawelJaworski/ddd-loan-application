package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms;

import java.util.*;

public class SmsOutboxInMemoryRepository implements SmsOutboxRepository {
    private final Map<UUID, SmsOutbox> data = new HashMap<>();

    @Override
    public SmsOutbox save(SmsOutbox entity) {
        return data.put(entity.getId(), entity);
    }

    @Override
    public Optional<SmsOutbox> findById(UUID id) {
        return Optional.ofNullable(data.get(id));
    }

    public void deleteAll() {
        data.clear();
    }
}
