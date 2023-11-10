package pl.javorek.ddd.service.applicationforloan.application.readmodel;

import java.util.Optional;
import java.util.UUID;

public interface ApplicationForALoanStateRepository {
    ApplicationForALoanState save(ApplicationForALoanState applicationForALoanState);
    Optional<ApplicationForALoanState> findOneById(UUID id);
}
