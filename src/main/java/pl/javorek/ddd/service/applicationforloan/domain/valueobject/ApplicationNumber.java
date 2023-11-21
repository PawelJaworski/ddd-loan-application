package pl.javorek.ddd.service.applicationforloan.domain.valueobject;

import lombok.Getter;
import pl.javorek.ddd.service.applicationforloan.domain.error.ApplicationForALoanException;


public class ApplicationNumber {
    @Getter
    private String asString;

    public ApplicationNumber(int applicationNumber) {
        if (applicationNumber <= 0) {
            throw new ApplicationForALoanException(
                    "Last application number cannot be less than 1 " + applicationNumber);
        }
        this.asString = "LOAN-" + applicationNumber;
    }
}
