package pl.javorek.ddd.service.applicationforloan.domain;

import lombok.Value;
import pl.javorek.ddd.service.applicationforloan.domain.error.ApplicationForALoanException;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent.RequestForLoanStartSent;
import pl.javorek.ddd.service.applicationforloan.domain.policy.ApplicationNumberPolicy;
import pl.javorek.ddd.service.applicationforloan.domain.policy.BankAgentPolicy;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.*;

@Value
public class ApplicationForALoan {

    ApplicationNumberPolicy applicationNumberPolicy;
    BankAgentPolicy bankAgentPolicy;
    RequiredDocuments requiredDocuments;

    public DomainEvent.LoanApplicationSubmitted requestForLoan(LoanRequestor loanRequestor) {
        return DomainEvent.LoanApplicationSubmitted.builder()
                .modifiedBy(bankAgentPolicy.getUsername())
                .applicationNumber(applicationNumberPolicy.getNextApplicationNumber())
                .loanRequestor(loanRequestor)
                .build();
    }

    public RequestForLoanStartSent sendRequestForLoanStart() {
        check(requiredDocuments.isAllRequiredDocumentsProvided(),
                "send-request-for-loan-start.error.not-all-required-documents-provided");

        return RequestForLoanStartSent.builder()
                .modifiedBy(bankAgentPolicy.getUsername())
                .build();
    }

    private void check(boolean condition, String error) {
        if (!condition) {
            throw new ApplicationForALoanException(error);
        }
    }
}
