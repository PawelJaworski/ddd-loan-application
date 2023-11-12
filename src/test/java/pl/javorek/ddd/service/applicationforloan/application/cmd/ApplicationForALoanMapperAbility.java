package pl.javorek.ddd.service.applicationforloan.application.cmd;

public interface ApplicationForALoanMapperAbility {
    ApplicationForALoanMapper INSTANCE = new ApplicationForALoanMapper();

    default ApplicationForALoanMapper getApplicationForALoanMapper() {
        return INSTANCE;
    }
}
