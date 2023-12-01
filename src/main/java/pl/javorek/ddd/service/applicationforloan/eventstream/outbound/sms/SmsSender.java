package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.command.DomainEventListener;
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent;

@Slf4j
@Component
@Builder
public class SmsSender implements DomainEventListener {
    @Override
    public void onDomainEvent(DomainEvent event, ApplicationForALoanEntity state) {
        if (event instanceof DomainEvent.CommunicationAboutStartedLoanSent communicationAboutStartedLoanSent) {
            communicationAboutStartedLoanSent.communicationType()
                    .forEach(it -> log.info("Communication sent: {}", it));
        }
    }
}
