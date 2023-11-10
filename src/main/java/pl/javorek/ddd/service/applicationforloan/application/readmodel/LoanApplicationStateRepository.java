package pl.javorek.ddd.service.applicationforloan.application.readmodel;

import java.util.Optional;
import java.util.UUID;

public interface LoanApplicationStateRepository {
    LoanApplicationState save(LoanApplicationState loanApplicationState);
    Optional<LoanApplicationState> findOneById(UUID id);
}
