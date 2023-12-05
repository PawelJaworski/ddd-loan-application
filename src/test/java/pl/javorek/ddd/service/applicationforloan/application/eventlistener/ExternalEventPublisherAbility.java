package pl.javorek.ddd.service.applicationforloan.application.eventlistener;

import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.ApplicationForALoanDocumentMapperImpl;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.ExternalEventPublisher;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.kafka.KafkaOutboxRepositoryAbility;


public interface ExternalEventPublisherAbility {
    ExternalEventPublisher INSTANCE = ExternalEventPublisher.builder()
            .kafkaOutboxRepository(KafkaOutboxRepositoryAbility.INSTANCE)
            .applicationForALoanDocumentMapper(new ApplicationForALoanDocumentMapperImpl())
            .build();

    default ExternalEventPublisher getExternalEventPublisher() {
        return INSTANCE;
    }
}