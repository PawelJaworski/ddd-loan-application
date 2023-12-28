package pl.javorek.ddd.service.applicationforloan.application.command;

import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntityRepositoryAbility;
import pl.javorek.ddd.service.applicationforloan.domain.policy.ApplicationNumberPolicy;

public interface ApplicationNumberPolicyAbility {
    ApplicationNumberDBPolicy INSTANCE = ApplicationNumberDBPolicy.builder()
            .applicationForALoanEntityRepository(ApplicationForALoanEntityRepositoryAbility.INSTANCE)
            .build();

    default ApplicationNumberPolicy getApplicationNumberPolicy() {
        return INSTANCE;
    }
}
