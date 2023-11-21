package pl.javorek.ddd.service.applicationforloan.application.command;

import pl.javorek.ddd.service.applicationforloan.application.command.DomainEventListenerComposite;
import pl.javorek.ddd.service.applicationforloan.application.eventlistener.ExternalEventPublisherAbility;
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
