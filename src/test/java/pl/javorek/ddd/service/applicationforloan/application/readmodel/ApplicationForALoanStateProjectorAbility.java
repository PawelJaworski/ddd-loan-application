package pl.javorek.ddd.service.applicationforloan.application.readmodel;

public interface ApplicationForALoanStateProjectorAbility {
    ApplicationForALoanStateProjector INSTANCE = ApplicationForALoanStateProjector.builder()
            .applicationForALoanStateRepository(ApplicationForALoanStateRepositoryAbility.INSTANCE)
            .build();

    default ApplicationForALoanStateProjector getLoanApplicationStateProjector() {
        return INSTANCE;
    }
}
