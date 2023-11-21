package pl.javorek.ddd.service.applicationforloan.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanState;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanStateRepository;

import java.util.Optional;
import java.util.UUID;

public interface ApplicationForAForALoanStateJpaRepository extends ApplicationForALoanStateRepository, JpaRepository<ApplicationForALoanState, UUID> {

    @Query("select max(a.applicationNumber.asString) from ApplicationForALoanState a")
    @Override
    Optional<String> findMaxApplicationNumberAsString();
}
