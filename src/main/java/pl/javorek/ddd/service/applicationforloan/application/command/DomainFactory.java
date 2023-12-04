package pl.javorek.ddd.service.applicationforloan.application.command;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.command.dto.ProvideRequiredDocumentCmd;
import pl.javorek.ddd.service.applicationforloan.application.command.dto.SubmitLoanApplicationCmd;
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.domain.ApplicationForALoan;
import pl.javorek.ddd.service.applicationforloan.domain.policy.ApplicationNumberPolicy;
import pl.javorek.ddd.service.applicationforloan.domain.policy.BankAgentPolicy;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocument;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.CommunicationAgreements;
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

    CommunicationAgreements newCommunicationAgreements(SubmitLoanApplicationCmd cmd) {
        return CommunicationAgreements.builder()
                .sms(cmd.smsAgreement())
                .email(cmd.emailAgreement())
                .build();
    }

    AttachedDocument newAttachedDocument(ProvideRequiredDocumentCmd cmd) {
        return AttachedDocument.builder()
                .type(cmd.documentType())
                .build();
    }

    ApplicationForALoan newApplicationForALoan() {
        var requiredDocuments = new RequiredDocuments();
        var communicationAgreements = CommunicationAgreements.builder()
                .sms(false)
                .email(false)
                .build();
        return new ApplicationForALoan(applicationNumberPolicy, bankAgentPolicy, requiredDocuments, communicationAgreements);
    }

    ApplicationForALoan newApplicationForALoan(ApplicationForALoanEntity state) {
        var requiredDocuments = new RequiredDocuments(state.getAttachedDocuments());
        var communicationAgreements = CommunicationAgreements.builder()
                .sms(state.getCommunicationAgreements().sms())
                .email(state.getCommunicationAgreements().email())
                .build();
        return new ApplicationForALoan(applicationNumberPolicy, bankAgentPolicy, requiredDocuments, communicationAgreements);
    }
}
