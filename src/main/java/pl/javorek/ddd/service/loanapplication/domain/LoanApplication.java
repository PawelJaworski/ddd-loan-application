package pl.javorek.ddd.service.loanapplication.domain;

import pl.javorek.ddd.service.loanapplication.domain.event.DomainEvent;

public class LoanApplication {
    public static DomainEvent.LoanRequested requestForLoan(LoanRequestor loanRequestor) {
        var applicationNumber = new ApplicationNumberVo();
        return new DomainEvent.LoanRequested(applicationNumber, loanRequestor);
    }
}
