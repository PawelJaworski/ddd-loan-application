package pl.javorek.ddd.service.applicationforloan.application.command;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.javorek.ddd.service.applicationforloan.application.outbound.EmailPublisher;
import pl.javorek.ddd.service.applicationforloan.application.outbound.ExternalEventPublisher;
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent;

@Service
@Builder
@RequiredArgsConstructor
class DomainEventListenerComposite implements DomainEventListener {

    private final ExternalEventPublisher eventPublisher;
    private final EmailPublisher emailPublisher;
    private final AuditProjection auditProjection;

    @Override
    public void onDomainEvent(DomainEvent event, ApplicationForALoanEntity state) {
        auditProjection.onDomainEvent(event, state);
        emailPublisher.onDomainEvent(event, state);
        eventPublisher.onDomainEvent(event, state);
    }
}
