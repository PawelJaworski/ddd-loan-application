package pl.javorek.ddd.service.applicationforloan.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.LoanApplicationState;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.LoanApplicationStateRepository;

import java.util.UUID;

public interface ApplicationForALoanStateJpaRepository extends LoanApplicationStateRepository, JpaRepository<LoanApplicationState, UUID> {
}
