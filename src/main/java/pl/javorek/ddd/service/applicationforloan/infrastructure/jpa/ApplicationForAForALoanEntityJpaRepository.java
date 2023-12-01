package pl.javorek.ddd.service.applicationforloan.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntityRepository;

import java.util.Optional;
import java.util.UUID;

public interface ApplicationForAForALoanEntityJpaRepository extends ApplicationForALoanEntityRepository, JpaRepository<ApplicationForALoanEntity, UUID> {

    @Query("select max(a.applicationNumber.asString) from ApplicationForALoanEntity a")
    @Override
    Optional<String> findMaxApplicationNumberAsString();
}
