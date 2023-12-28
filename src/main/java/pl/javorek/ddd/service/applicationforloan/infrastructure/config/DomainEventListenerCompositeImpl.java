package pl.javorek.ddd.service.applicationforloan.infrastructure.config;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.javorek.ddd.service.applicationforloan.application.command.DomainEventListenerComposite;
import pl.javorek.ddd.service.applicationforloan.application.command.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.application.query.AuditProjection;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms.SmsSender;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.ExternalEventPublisher;

@Service
@Builder
@RequiredArgsConstructor
class DomainEventListenerCompositeImpl implements DomainEventListenerComposite {

    private final ExternalEventPublisher externalEventPublisher;
    private final AuditProjection auditProjection;
    private final SmsSender smsSender;

    @Override
    public void onDomainEvent(DomainEvent event, ApplicationForALoanEntity state) {
        auditProjection.onDomainEvent(event, state);
        externalEventPublisher.onDomainEvent(event, state);
        smsSender.onDomainEvent(event, state);
    }
}
