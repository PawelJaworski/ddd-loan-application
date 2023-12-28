package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.kafka;

import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.persistence.ApplicationForALoanDocumentOutbox;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.persistence.ApplicationForALoanDocumentOutboxRepository;

import java.util.Optional;
import java.util.UUID;

public interface KafkaOutboxRepositoryAbility {
    ApplicationForALoanDocumentOutboxRepository INSTANCE = new ApplicationForALoanDocumentOutboxInMemoryRepository();

    default ApplicationForALoanDocumentOutboxRepository getKafkaOutboxRepository() {
        return INSTANCE;
    }

    default Optional<ApplicationForALoanDocumentOutbox> with_kafka_sent(UUID id) {
      return getKafkaOutboxRepository().findById(id);
    }

}
