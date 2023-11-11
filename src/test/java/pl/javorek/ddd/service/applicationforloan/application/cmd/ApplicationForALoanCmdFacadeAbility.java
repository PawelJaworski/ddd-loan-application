package pl.javorek.ddd.service.applicationforloan.application.cmd;

import pl.javorek.ddd.service.applicationforloan.application.eventlistener.DomainEventListenerCompositeAbility;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanStateRepositoryAbility;

import java.math.BigDecimal;
import java.util.UUID;

public interface ApplicationForALoanCmdFacadeAbility {
    ApplicationForALoanCmdFacade INSTANCE = ApplicationForALoanCmdFacade.builder()
            .applicationForALoanStateRepository(ApplicationForALoanStateRepositoryAbility.INSTANCE)
            .domainEventListenerComposite(DomainEventListenerCompositeAbility.INSTANCE)
            .build();

    default UUID loan_application_submitted() {
        var cmd = SubmitLoanApplicationCmd.builder()
                .name("Jan")
                .lastName("Kowalski")
                .loanAmount(new BigDecimal("10000.00"))
                .build();
        return getApplicationForALoanCmdFacade().requestForLoan(cmd);
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
