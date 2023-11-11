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

    default UUID loan_requested() {
        var cmd = RequestForALoanCmd.builder()
                .name("Jan")
                .lastName("Kowalski")
                .loanAmount(new BigDecimal("10000.00"))
                .build();
        return getApplicationForALoanCmdFacade().requestForLoan(cmd);
    }

    default ApplicationForALoanCmdFacade getApplicationForALoanCmdFacade() {
        return INSTANCE;
    }
}
