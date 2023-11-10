package pl.javorek.ddd.service.applicationforloan.domain;

import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.LoanRequestor;

import java.util.UUID;

public class ApplicationForALoan {
    public static DomainEvent.LoanRequested requestForLoan(LoanRequestor loanRequestor) {
        var id = UUID.randomUUID();
        var applicationNumber = new ApplicationNumber();
        return new DomainEvent.LoanRequested(id, applicationNumber, loanRequestor);
    }
}
