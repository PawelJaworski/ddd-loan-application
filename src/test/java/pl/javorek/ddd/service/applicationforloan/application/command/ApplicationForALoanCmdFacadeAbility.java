package pl.javorek.ddd.service.applicationforloan.application.command;

import pl.javorek.ddd.service.applicationforloan.application.command.dto.ProvideRequiredDocumentCmd;
import pl.javorek.ddd.service.applicationforloan.application.command.dto.SendCommunicationAboutStartedLoanCmd;
import pl.javorek.ddd.service.applicationforloan.application.command.dto.SendRequestForLoanStartCmd;
import pl.javorek.ddd.service.applicationforloan.application.command.dto.SubmitLoanApplicationCmd;
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntityRepositoryAbility;
import pl.javorek.ddd.service.applicationforloan.application.persistence.EventStoreEntityRepositoryAbility;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocumentType;
import pl.javorek.ddd.service.applicationforloan.infrastructure.config.DomainEventListenerCompositeAbility;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.Consumer;

public interface ApplicationForALoanCmdFacadeAbility {
    ApplicationForALoanCmdFacade INSTANCE = ApplicationForALoanCmdFacade.builder()
            .applicationForALoanEntityRepository(ApplicationForALoanEntityRepositoryAbility.INSTANCE)
            .domainEventListenerComposite(DomainEventListenerCompositeAbility.INSTANCE)
            .domainFactory(DomainFactoryAbility.INSTANCE)
            .eventStoreEntityRepository(EventStoreEntityRepositoryAbility.INSTANCE)
            .build();

    default UUID loan_application_submitted(Consumer<SubmitLoanApplicationCmd.SubmitLoanApplicationCmdBuilder> builder) {
        var cmd = SubmitLoanApplicationCmd.builder()
                .name("Jan")
                .lastName("Kowalski")
                .loanAmount(new BigDecimal("10000.00"));
        builder.accept(cmd);

        return getApplicationForALoanCmdFacade().submitLoanApplication(cmd.build());
    }

    default UUID loan_application_submitted() {
        var cmd = SubmitLoanApplicationCmd.builder()
                .name("Jan")
                .lastName("Kowalski")
                .loanAmount(new BigDecimal("10000.00"))
                .build();
        return getApplicationForALoanCmdFacade().submitLoanApplication(cmd);
    }

    default void all_required_documents_provided(UUID id) {
        document_provided(id, AttachedDocumentType.GDPR);
        document_provided(id, AttachedDocumentType.EMPLOYMENT_CERTIFICATE);
        document_provided(id, AttachedDocumentType.BANK_ACCOUNT_STATEMENT);
    }

    default void communication_about_started_loan_sent(String applicationNumber) {
        var cmd = new SendCommunicationAboutStartedLoanCmd(applicationNumber);
        getApplicationForALoanCmdFacade().sendCommunicationAboutStartedLoan(cmd);
    }

    private void document_provided(UUID id, AttachedDocumentType type) {
        var cmd = ProvideRequiredDocumentCmd.builder()
                .id(id)
                .documentType(type)
                .build();
        getApplicationForALoanCmdFacade().provideRequiredDocuments(cmd);
    }

    default void request_for_loan_start_sent(UUID id) {
        var cmd = SendRequestForLoanStartCmd.builder()
                .id(id)
                .build();

        getApplicationForALoanCmdFacade().sendRequestForLoanStart(cmd);
    }

    default ApplicationForALoanCmdFacade getApplicationForALoanCmdFacade() {
        return INSTANCE;
    }
}
