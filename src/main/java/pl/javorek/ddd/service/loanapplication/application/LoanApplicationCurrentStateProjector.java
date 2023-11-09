package pl.javorek.ddd.service.loanapplication.application;

import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.loanapplication.domain.LoanApplicationCurrentState;
import pl.javorek.ddd.service.loanapplication.domain.event.DomainEvent;

import java.util.UUID;

@Component
public class LoanApplicationCurrentStateProjector {
    public LoanApplicationCurrentState accept(DomainEvent.LoanRequested loanRequested) {
        return LoanApplicationCurrentState.builder()
                .id(UUID.randomUUID())
                .applicationNumber(loanRequested.applicationNumber())
                .build();
    }
}
