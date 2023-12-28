package pl.javorek.ddd.service.applicationforloan.application.command.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.javorek.ddd.service.applicationforloan.application.command.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.application.command.persistence.ApplicationForALoanEntityRepository;

import java.util.Optional;
import java.util.UUID;

public interface ApplicationForAForALoanEntityJpaRepository extends ApplicationForALoanEntityRepository, JpaRepository<ApplicationForALoanEntity, UUID> {

    @Query("select max(a.applicationNumber.asString) from ApplicationForALoanEntity a")
    @Override
    Optional<String> findMaxApplicationNumberAsString();
}
