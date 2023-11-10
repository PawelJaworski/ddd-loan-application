package pl.javorek.ddd.service.applicationforloan.application.readmodel;

public interface LoanApplicationStateProjectorAbility {
    LoanApplicationStateProjector INSTANCE = LoanApplicationStateProjector.builder().build();

    default LoanApplicationStateProjector getLoanApplicationStateProjector() {
        return INSTANCE;
    }
}