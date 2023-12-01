package pl.javorek.ddd.service.applicationforloan.domain;

import lombok.Value;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent.CommunicationAboutStartedLoanSent;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent.RequestForLoanStartSent;
import pl.javorek.ddd.service.applicationforloan.domain.policy.ApplicationNumberPolicy;
import pl.javorek.ddd.service.applicationforloan.domain.policy.BankAgentPolicy;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.*;

import java.time.LocalDateTime;

@Value
public class ApplicationForALoan {

    ApplicationNumberPolicy applicationNumberPolicy;
    BankAgentPolicy bankAgentPolicy;
    RequiredDocuments requiredDocuments;
    CommunicationAgreements communicationAgreements;

    public DomainEvent.LoanApplicationSubmitted requestForLoan(LoanRequestor loanRequestor, CommunicationAgreements communicationAgreements) {
        return DomainEvent.LoanApplicationSubmitted.builder()
                .modifiedBy(bankAgentPolicy.getUsername())
                .applicationNumber(applicationNumberPolicy.getNextApplicationNumber())
                .loanRequestor(loanRequestor)
                .communicationAgreements(communicationAgreements)
                .build();
    }

    public RequestForLoanStartSent sendRequestForLoanStart() {
        check(requiredDocuments.isAllRequiredDocumentsProvided(),
                "send-request-for-loan-start.error.not-all-required-documents-provided");

        return RequestForLoanStartSent.builder()
                .modifiedBy(bankAgentPolicy.getUsername())
                .build();
    }

    public CommunicationAboutStartedLoanSent sendClientCommunicationForStartedLoan() {
        return CommunicationAboutStartedLoanSent.builder()
                .modificationTime(LocalDateTime.now())
                .sms(communicationAgreements.sms())
                .email(communicationAgreements.email())
                .build();
    }

    private void check(boolean condition, String error) {
        if (!condition) {
            throw new ApplicationForALoanException(error);
        }
    }
}
