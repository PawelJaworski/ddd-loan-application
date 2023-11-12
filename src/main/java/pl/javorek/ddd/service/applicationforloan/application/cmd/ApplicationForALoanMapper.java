package pl.javorek.ddd.service.applicationforloan.application.cmd;

import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanState;
import pl.javorek.ddd.service.applicationforloan.domain.ApplicationForALoan;

@Component
public class ApplicationForALoanMapper {
    ApplicationForALoan map(ApplicationForALoanState state) {
        return new ApplicationForALoan(state.getAttachedDocuments());
    }
}
