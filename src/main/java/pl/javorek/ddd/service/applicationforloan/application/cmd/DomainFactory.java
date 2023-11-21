package pl.javorek.ddd.service.applicationforloan.application.cmd;

import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanState;
import pl.javorek.ddd.service.applicationforloan.domain.ApplicationForALoan;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocument;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.LoanRequestor;

@Component
class DomainFactory {
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

    ApplicationForALoan newApplicationForALoan(ApplicationForALoanState state) {
        return new ApplicationForALoan(state.getAttachedDocuments());
    }
}
