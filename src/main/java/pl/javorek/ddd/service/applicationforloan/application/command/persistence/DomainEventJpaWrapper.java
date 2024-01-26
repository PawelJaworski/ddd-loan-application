package pl.javorek.ddd.service.applicationforloan.application.command.persistence;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent.CommunicationAboutStartedLoanSent;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent.LoanApplicationSubmitted;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent.RequestForLoanStartSent;

import java.util.Optional;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class DomainEventJpaWrapper {
    private LoanApplicationSubmitted loanApplicationSubmitted;
    private RequestForLoanStartSent requestForLoanStartSent;
    private CommunicationAboutStartedLoanSent communicationAboutStartedLoanSent;

    public DomainEventJpaWrapper(DomainEvent domainEvent) {
        if (domainEvent instanceof LoanApplicationSubmitted loanApplicationSubmitted) {
            this.loanApplicationSubmitted = loanApplicationSubmitted;
        } else if (domainEvent instanceof RequestForLoanStartSent requestForLoanStartSent) {
            this.requestForLoanStartSent = requestForLoanStartSent;
        } else if (domainEvent instanceof CommunicationAboutStartedLoanSent communicationAboutStartedLoanSent) {
            this.communicationAboutStartedLoanSent = communicationAboutStartedLoanSent;
        }
    }

    public DomainEvent domainEvent() {
        return Optional.ofNullable(loanApplicationSubmitted)
                .flatMap(it -> Optional.ofNullable(requestForLoanStartSent))
                .flatMap(it ->Optional.ofNullable(communicationAboutStartedLoanSent))
                .orElse(null);
    }
}
