package pl.javorek.ddd.service.applicationforloan.application.eventlistener;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.javorek.ddd.service.applicationforloan.application.integration.EmailPublisher;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanState;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;

@Service
@Builder
@RequiredArgsConstructor
public class DomainEventListenerComposite implements DomainEventListener {

    private final ExternalEventPublisher eventPublisher;
    private final EmailPublisher emailPublisher;

    @Override
    public void onDomainEvent(DomainEvent event, ApplicationForALoanState state) {
        emailPublisher.onDomainEvent(event, state);
        eventPublisher.onDomainEvent(event, state);
    }
}