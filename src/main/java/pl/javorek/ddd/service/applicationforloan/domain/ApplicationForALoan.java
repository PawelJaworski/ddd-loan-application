package pl.javorek.ddd.service.applicationforloan.domain;

import lombok.Value;
import pl.javorek.ddd.service.applicationforloan.domain.error.ApplicationForALoanException;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent.RequestForLoanStartSent;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocument;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocumentType;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.LoanRequestor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocumentType.*;

@Value
public class ApplicationForALoan {
    private static Set<AttachedDocumentType> REQUIRED_DOCUMENT_TYPES = Set.of(EMPLOYMENT_CERTIFICATE,
            BANK_ACCOUNT_STATEMENT, GDPR);

    List<AttachedDocument> attachedDocuments;

    public static DomainEvent.LoanApplicationSubmitted requestForLoan(LoanRequestor loanRequestor) {
        var applicationNumber = new ApplicationNumber();
        return DomainEvent.LoanApplicationSubmitted.builder()
                .modifiedBy("testUser")
                .applicationNumber(applicationNumber)
                .loanRequestor(loanRequestor)
                .build();
    }

    public RequestForLoanStartSent sendRequestForLoanStart() {
        var attachedDocumentTypes = attachedDocuments.stream()
                .map(AttachedDocument::getType)
                .collect(Collectors.toSet());

        if (!attachedDocumentTypes.containsAll(REQUIRED_DOCUMENT_TYPES)) {
            throw new ApplicationForALoanException("send-request-for-loan-start.error.not-all-required-documents-provided");
        }

        return RequestForLoanStartSent.builder()
                .build();
    }
}
