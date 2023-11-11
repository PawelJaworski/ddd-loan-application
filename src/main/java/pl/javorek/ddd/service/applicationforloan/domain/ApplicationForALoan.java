package pl.javorek.ddd.service.applicationforloan.domain;

import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.LoanRequestor;

public class ApplicationForALoan {
    public static DomainEvent.LoanApplicationSubmitted requestForLoan(LoanRequestor loanRequestor) {
        var applicationNumber = new ApplicationNumber();
        return DomainEvent.LoanApplicationSubmitted.builder()
                .modifiedBy("testUser")
                .applicationNumber(applicationNumber)
                .loanRequestor(loanRequestor)
                .build();
    }
}
