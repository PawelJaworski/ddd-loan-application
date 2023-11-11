package pl.javorek.ddd.service.applicationforloan.domain.error;

public class ApplicationForALoanException extends RuntimeException {
    public ApplicationForALoanException(String message) {
        super(message);
    }
}
