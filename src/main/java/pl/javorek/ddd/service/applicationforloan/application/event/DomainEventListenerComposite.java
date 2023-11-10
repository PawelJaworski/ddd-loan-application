package pl.javorek.ddd.service.applicationforloan.application.event;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.LoanApplicationState;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.LoanApplicationStateProjector;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;

@Service
@RequiredArgsConstructor
public class DomainEventListenerComposite implements DomainEventListener {

    private final LoanApplicationStateProjector loanApplicationStateProjector;
    private final ExternalEventPublisher eventPublisher;

    @Override
    public void onDomainEvent(DomainEvent event, LoanApplicationState state) {
        loanApplicationStateProjector.onDomainEvent(event, state);
        eventPublisher.onDomainEvent(event, state);
    }
}
