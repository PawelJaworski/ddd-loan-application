package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.command.DomainEventListener;
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent;

import java.time.LocalDateTime;

@Component
@Builder
@RequiredArgsConstructor
public class ExternalEventPublisher implements DomainEventListener {
    private final ApplicationForALoanDocumentMapper applicationForALoanDocumentMapper;
    private final KafkaOutboxRepository kafkaOutboxRepository;

    @Override
    @SneakyThrows
    public void onDomainEvent(DomainEvent event, ApplicationForALoanEntity state) {
        var message = applicationForALoanDocumentMapper.map(state);
        var outbox = new KafkaOutbox(state.getId(), new KafkaMessage(LocalDateTime.now(), message));

        kafkaOutboxRepository.save(outbox);

    }
}
