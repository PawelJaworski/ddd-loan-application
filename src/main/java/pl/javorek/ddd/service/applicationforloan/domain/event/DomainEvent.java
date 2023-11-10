package pl.javorek.ddd.service.applicationforloan.domain.event;

import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.LoanRequestor;

import java.util.UUID;

public sealed interface DomainEvent {
    UUID id();

    record LoanRequested(UUID id, ApplicationNumber applicationNumber,
                         LoanRequestor loanRequestor) implements DomainEvent {
    }
}
