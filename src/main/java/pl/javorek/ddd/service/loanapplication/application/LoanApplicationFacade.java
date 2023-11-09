package pl.javorek.ddd.service.loanapplication.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.javorek.ddd.service.loanapplication.application.cmd.RequestForLoanCmd;
import pl.javorek.ddd.service.loanapplication.domain.LoanApplication;
import pl.javorek.ddd.service.loanapplication.domain.LoanRequestor;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class LoanApplicationFacade {
    private final LoanApplicationCurrentStateProjector loanApplicationCurrentStateProjector;

    public UUID requestForLoan(RequestForLoanCmd cmd) {
        var loanRequestor = new LoanRequestor();
        var event = LoanApplication.requestForLoan(loanRequestor);

        var state = loanApplicationCurrentStateProjector.accept(event);
        return state.getId();
    }
}
