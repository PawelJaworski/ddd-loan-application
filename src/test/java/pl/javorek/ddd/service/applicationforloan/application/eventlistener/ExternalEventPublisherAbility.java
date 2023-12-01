package pl.javorek.ddd.service.applicationforloan.application.eventlistener;

import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.external.ExternalEventPublisher;

public interface ExternalEventPublisherAbility {
    ExternalEventPublisher INSTANCE = ExternalEventPublisher.builder().build();

    default ExternalEventPublisher getExternalEventPublisher() {
        return INSTANCE;
    }
}