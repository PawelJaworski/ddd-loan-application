package pl.javorek.ddd.service.applicationforloan.application.command;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanState;
import pl.javorek.ddd.service.applicationforloan.domain.ApplicationForALoan;
import pl.javorek.ddd.service.applicationforloan.domain.policy.ApplicationNumberPolicy;
import pl.javorek.ddd.service.applicationforloan.domain.policy.BankAgentPolicy;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocument;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.LoanRequestor;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.RequiredDocuments;

@Component
@Builder
@RequiredArgsConstructor
class DomainFactory {
    private final BankAgentPolicy bankAgentPolicy;
    private final ApplicationNumberPolicy applicationNumberPolicy;

    LoanRequestor newLoanRequestor(SubmitLoanApplicationCmd cmd) {
        return LoanRequestor.builder()
                .name(cmd.name())
                .lastName(cmd.lastName())
                .build();
    }

    AttachedDocument newAttachedDocument(ProvideRequiredDocumentCmd cmd) {
        return AttachedDocument.builder()
                .type(cmd.documentType())
                .build();
    }

    ApplicationForALoan newApplicationForALoan() {
        var requiredDocuments = new RequiredDocuments();
        return new ApplicationForALoan(applicationNumberPolicy, bankAgentPolicy, requiredDocuments);
    }

    ApplicationForALoan newApplicationForALoan(ApplicationForALoanState state) {
        var requiredDocuments = new RequiredDocuments(state.getAttachedDocuments());
        return new ApplicationForALoan(applicationNumberPolicy, bankAgentPolicy, requiredDocuments);
    }
}
