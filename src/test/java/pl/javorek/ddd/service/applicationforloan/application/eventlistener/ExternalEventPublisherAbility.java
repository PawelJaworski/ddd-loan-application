package pl.javorek.ddd.service.applicationforloan.application.eventlistener;

public interface ExternalEventPublisherAbility {
    ExternalEventPublisher INSTANCE = ExternalEventPublisher.builder().build();

    default ExternalEventPublisher getExternalEventPublisher() {
        return INSTANCE;
    }
}