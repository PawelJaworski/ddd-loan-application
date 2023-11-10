package pl.javorek.ddd.service.applicationforloan.application.eventlistener;

import pl.javorek.ddd.service.applicationforloan.application.outbound.EmailPublisherAbility;

public interface DomainEventListenerCompositeAbility {
    DomainEventListenerComposite INSTANCE = DomainEventListenerComposite.builder()
            .emailPublisher(EmailPublisherAbility.INSTANCE)
            .eventPublisher(ExternalEventPublisherAbility.INSTANCE)
            .build();

    default DomainEventListenerComposite getDomainEventListenerComposite() {
        return INSTANCE;
    }
}
