package pl.javorek.ddd.service.applicationforloan.domain.valueobject;

import lombok.*;
import pl.javorek.ddd.service.applicationforloan.domain.ApplicationForALoanException;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
