package pl.javorek.ddd.service.applicationforloan.infrastructure;

import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanStateRepositoryAbility;
import pl.javorek.ddd.service.applicationforloan.domain.policy.ApplicationNumberPolicy;

public interface ApplicationNumberPolicyAbility {
    ApplicationNumberDBPolicy INSTANCE = ApplicationNumberDBPolicy.builder()
            .applicationForALoanStateRepository(ApplicationForALoanStateRepositoryAbility.INSTANCE)
            .build();

    default ApplicationNumberPolicy getApplicationNumberPolicy() {
        return INSTANCE;
    }
}