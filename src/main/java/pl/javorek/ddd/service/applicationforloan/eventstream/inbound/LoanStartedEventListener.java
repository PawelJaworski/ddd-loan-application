package pl.javorek.ddd.service.applicationforloan.eventstream.inbound;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.command.ApplicationForALoanCmdFacade;
import pl.javorek.ddd.service.applicationforloan.application.command.dto.SendCommunicationAboutStartedLoanCmd;
import pl.javorek.ddd.service.applicationforloan.eventstream.inbound.contract.LoanStartedEvent;

import java.util.Optional;

@Component
@RequiredArgsConstructor
class LoanStartedEventListener {
    private ApplicationForALoanCmdFacade applicationForALoanCmdFacade;

    public void onLoanStarted(LoanStartedEvent event) {
        Optional.ofNullable(event)
                .map(LoanStartedEvent::applicationNumber)
                .map(SendCommunicationAboutStartedLoanCmd::new)
                .ifPresent(applicationForALoanCmdFacade::sendCommunicationAboutStartedLoan);
    }
}
