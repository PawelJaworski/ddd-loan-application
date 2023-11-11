package pl.javorek.ddd.service.applicationforloan.domain;

import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.LoanRequestor;

import java.util.UUID;

public class ApplicationForALoan {
    public static DomainEvent.LoanRequested requestForLoan(LoanRequestor loanRequestor) {
        var applicationNumber = new ApplicationNumber();
        return DomainEvent.LoanRequested.builder()
                .modifiedBy("testUser")
                .applicationNumber(applicationNumber)
                .loanRequestor(loanRequestor)
                .build();
    }
}
