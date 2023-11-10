package pl.javorek.ddd.service.applicationforloan.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanState;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanStateRepository;

import java.util.UUID;

public interface ApplicationForAForALoanStateJpaRepository extends ApplicationForALoanStateRepository, JpaRepository<ApplicationForALoanState, UUID> {
}
