package pl.javorek.ddd.service.applicationforloan.infrastructure;

import pl.javorek.ddd.service.applicationforloan.application.command.AuditProjectionAbility;
import pl.javorek.ddd.service.applicationforloan.application.eventlistener.ExternalEventPublisherAbility;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.ClientCommunicationSenderAbility;

public interface DomainEventListenerCompositeAbility {
    DomainEventListenerCompositeImpl INSTANCE = DomainEventListenerCompositeImpl.builder()
            .externalEventKafkaPublisher(ExternalEventPublisherAbility.INSTANCE)
            .auditProjection(AuditProjectionAbility.INSTANCE)
            .smsSender(ClientCommunicationSenderAbility.INSTANCE)
            .build();

    default DomainEventListenerCompositeImpl getDomainEventListenerComposite() {
        return INSTANCE;
    }
}
