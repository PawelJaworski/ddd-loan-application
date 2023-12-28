package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.command.DomainEventListener;
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent;

@Component
@Builder
@RequiredArgsConstructor
public class ExternalEventPublisher implements DomainEventListener {
    private final ApplicationForALoanDocumentMapper applicationForALoanDocumentMapper;
    private final ApplicationForALoanDocumentOutboxRepository applicationForALoanDocumentOutboxRepository;

    @Override
    @SneakyThrows
    public void onDomainEvent(DomainEvent event, ApplicationForALoanEntity state) {
        var message = applicationForALoanDocumentMapper.map(state);
        var outbox = new ApplicationForALoanDocumentOutbox(state.getId(), message);

        applicationForALoanDocumentOutboxRepository.save(outbox);
    }
}
