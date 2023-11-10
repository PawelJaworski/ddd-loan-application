package pl.javorek.ddd.service.applicationforloan.application.readmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.eventlistener.DomainEventListener;
import pl.javorek.ddd.service.applicationforloan.domain.event.DomainEvent;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationStatusType;

@Component
@Builder
@AllArgsConstructor
public class ApplicationForALoanStateProjector  {

    private final ApplicationForALoanStateRepository applicationForALoanStateRepository;

    public ApplicationForALoanState accept(DomainEvent event, ApplicationForALoanState state) {
        if (event instanceof DomainEvent.LoanRequested loanRequested) {
            return accept(loanRequested, state);
        }

        return state;
    }

    private ApplicationForALoanState accept(DomainEvent.LoanRequested loanRequested, ApplicationForALoanState state) {
        state.setApplicationNumber(loanRequested.applicationNumber());
        state.setApplicationStatus(ApplicationStatusType.DRAFT);

        return applicationForALoanStateRepository.save(state);
    }
}
