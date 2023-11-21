package pl.javorek.ddd.service.applicationforloan.application.readmodel;

import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent.RequestForLoanStartSent;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationStatusType;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocument;

import java.util.Optional;
import java.util.UUID;

public interface ApplicationForALoanStateRepository {

    default ApplicationForALoanState save(DomainEvent.LoanApplicationSubmitted event) {
        var state = new ApplicationForALoanState(UUID.randomUUID());
        state.setApplicationNumber(event.applicationNumber());
        state.setApplicationStatus(ApplicationStatusType.DRAFT);
        state.setLoanRequestor(event.loanRequestor());

        return save(state);
    }

    default ApplicationForALoanState save(ApplicationForALoanState state, AttachedDocument attachedDocument) {
        state.addDocument(attachedDocument);

        return state;
    }

    default ApplicationForALoanState save(ApplicationForALoanState state, DomainEvent event) {
        if (event instanceof RequestForLoanStartSent requestForLoanStartSent) {
            return saveRequestForLoanStartSent(state, requestForLoanStartSent);
        }

        return state;
    }

    private ApplicationForALoanState saveRequestForLoanStartSent(ApplicationForALoanState state,
                                                                 RequestForLoanStartSent requestForLoanStartSent) {
        state.setApplicationStatus(ApplicationStatusType.WAITING_FOR_APPROVAL);

        return state;
    }

    ApplicationForALoanState save(ApplicationForALoanState applicationForALoanState);
    Optional<ApplicationForALoanState> findOneById(UUID id);

    Optional<String> findMaxApplicationNumberAsString();
}
