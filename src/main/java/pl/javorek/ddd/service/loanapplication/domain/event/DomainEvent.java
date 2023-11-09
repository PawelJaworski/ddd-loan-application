package pl.javorek.ddd.service.loanapplication.domain.event;

import pl.javorek.ddd.service.loanapplication.domain.ApplicationNumberVo;
import pl.javorek.ddd.service.loanapplication.domain.LoanRequestor;

import java.util.UUID;

public sealed interface DomainEvent {
    record LoanRequested(ApplicationNumberVo applicationNumber, LoanRequestor loanRequestor) implements DomainEvent {}
}
