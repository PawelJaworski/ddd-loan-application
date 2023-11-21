package pl.javorek.ddd.service.applicationforloan.domain;

import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanStateRepositoryAbility;
import pl.javorek.ddd.service.applicationforloan.domain.policy.ApplicationNumberPolicy;
import pl.javorek.ddd.service.applicationforloan.infrastructure.ApplicationNumberDBPolicy;

public interface ApplicationNumberPolicyAbility {
    ApplicationNumberDBPolicy INSTANCE = ApplicationNumberDBPolicy.builder()
            .applicationForALoanStateRepository(ApplicationForALoanStateRepositoryAbility.INSTANCE)
            .build();

    default ApplicationNumberPolicy getApplicationNumberPolicy() {
        return INSTANCE;
    }
}