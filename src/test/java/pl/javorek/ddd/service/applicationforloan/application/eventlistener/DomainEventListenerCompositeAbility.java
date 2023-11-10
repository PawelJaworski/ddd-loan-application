package pl.javorek.ddd.service.applicationforloan.application.eventlistener;

import pl.javorek.ddd.service.applicationforloan.application.readmodel.LoanApplicationStateProjectorAbility;

public interface DomainEventListenerCompositeAbility {
    DomainEventListenerComposite INSTANCE = DomainEventListenerComposite.builder()
            .loanApplicationStateProjector(LoanApplicationStateProjectorAbility.INSTANCE)
            .eventPublisher(ExternalEventPublisherAbility.INSTANCE)
            .build();

    default DomainEventListenerComposite getDomainEventListenerComposite() {
        return INSTANCE;
    }
}