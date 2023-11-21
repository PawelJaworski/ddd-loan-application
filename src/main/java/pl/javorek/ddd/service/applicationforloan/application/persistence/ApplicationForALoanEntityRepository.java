package pl.javorek.ddd.service.applicationforloan.application.persistence;

import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent.RequestForLoanStartSent;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationStatusType;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocument;

import java.util.Optional;
import java.util.UUID;

public interface ApplicationForALoanEntityRepository {

    default ApplicationForALoanEntity save(DomainEvent.LoanApplicationSubmitted event) {
        var state = new ApplicationForALoanEntity(UUID.randomUUID());
        state.setApplicationNumber(event.applicationNumber());
        state.setApplicationStatus(ApplicationStatusType.DRAFT);
        state.setLoanRequestor(event.loanRequestor());

        return save(state);
    }

    default ApplicationForALoanEntity save(ApplicationForALoanEntity state, AttachedDocument attachedDocument) {
        state.addDocument(attachedDocument);

        return state;
    }

    default ApplicationForALoanEntity save(ApplicationForALoanEntity state, DomainEvent event) {
        if (event instanceof RequestForLoanStartSent requestForLoanStartSent) {
            return saveRequestForLoanStartSent(state, requestForLoanStartSent);
        }

        return state;
    }

    private ApplicationForALoanEntity saveRequestForLoanStartSent(ApplicationForALoanEntity state,
                                                                  RequestForLoanStartSent requestForLoanStartSent) {
        state.setApplicationStatus(ApplicationStatusType.WAITING_FOR_APPROVAL);

        return state;
    }

    ApplicationForALoanEntity save(ApplicationForALoanEntity applicationForALoanEntity);
    Optional<ApplicationForALoanEntity> findOneById(UUID id);

    Optional<String> findMaxApplicationNumberAsString();
}
