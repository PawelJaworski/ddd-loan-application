package pl.javorek.ddd.service.applicationforloan.infrastructure;

import pl.javorek.ddd.service.applicationforloan.application.command.AuditProjectionAbility;
import pl.javorek.ddd.service.applicationforloan.application.eventlistener.ExternalEventPublisherAbility;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms.SmsSenderAbility;

public interface DomainEventListenerCompositeAbility {
    DomainEventListenerCompositeImpl INSTANCE = DomainEventListenerCompositeImpl.builder()
            .externalEventPublisher(ExternalEventPublisherAbility.INSTANCE)
            .auditProjection(AuditProjectionAbility.INSTANCE)
            .smsSender(SmsSenderAbility.INSTANCE)
            .build();

    default DomainEventListenerCompositeImpl getDomainEventListenerComposite() {
        return INSTANCE;
    }
}
