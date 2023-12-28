package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.command.DomainEventListener;
import pl.javorek.ddd.service.applicationforloan.application.command.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms.contract.SmsMessage;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms.persistence.SmsOutbox;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms.persistence.SmsOutboxRepository;

import java.time.LocalDateTime;

@Slf4j
@Component
@Builder
@RequiredArgsConstructor
public class SmsSender implements DomainEventListener {
    private final SmsOutboxRepository smsOutboxRepository;

    @Override
    public void onDomainEvent(DomainEvent event, ApplicationForALoanEntity state) {
        if (event instanceof DomainEvent.CommunicationAboutStartedLoanSent communicationAboutStartedLoanSent) {
            if (communicationAboutStartedLoanSent.sms()) {
                var content = new SmsMessage(LocalDateTime.now(), state.getLoanRequestor().phoneNumber(), "sms content");
                var sms = new SmsOutbox(state.getId(), content);
                smsOutboxRepository.save(sms);
            }

        }
    }
}
