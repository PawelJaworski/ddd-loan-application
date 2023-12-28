package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.kafka;

import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.persistence.ApplicationForALoanDocumentOutbox;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.persistence.ApplicationForALoanDocumentOutboxRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ApplicationForALoanDocumentOutboxInMemoryRepository implements ApplicationForALoanDocumentOutboxRepository {
    private final Map<UUID, ApplicationForALoanDocumentOutbox> data = new HashMap<>();

    @Override
    public ApplicationForALoanDocumentOutbox save(ApplicationForALoanDocumentOutbox entity) {
        return data.put(entity.getId(), entity);
    }

    @Override
    public Optional<ApplicationForALoanDocumentOutbox> findById(UUID id) {
        return Optional.ofNullable(data.get(id));
    }

    public void deleteAll() {
        data.clear();
    }
}
