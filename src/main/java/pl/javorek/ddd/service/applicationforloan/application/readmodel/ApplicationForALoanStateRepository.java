package pl.javorek.ddd.service.applicationforloan.application.readmodel;

import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationStatusType;

import java.util.Optional;
import java.util.UUID;

public interface ApplicationForALoanStateRepository {

    default ApplicationForALoanState save(DomainEvent.LoanRequested event) {
        var state = new ApplicationForALoanState(UUID.randomUUID());
        state.setApplicationNumber(event.applicationNumber());
        state.setApplicationStatus(ApplicationStatusType.DRAFT);

        return save(state);
    }

    default ApplicationForALoanState save(ApplicationForALoanState state, DomainEvent event) {
        if (event instanceof DomainEvent.LoanRequested loanRequested) {
            return save(state, loanRequested);
        }

        return state;
    }

    ApplicationForALoanState save(ApplicationForALoanState applicationForALoanState);
    Optional<ApplicationForALoanState> findOneById(UUID id);
}
