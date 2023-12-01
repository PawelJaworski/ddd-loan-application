package pl.javorek.ddd.service.applicationforloan.domain;

import lombok.Builder;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.LoanRequestor;

import java.time.LocalDateTime;
import java.util.List;

public sealed interface DomainEvent {

    @Builder
    record LoanApplicationSubmitted(String modifiedBy, LocalDateTime modificationTime,
                                    ApplicationNumber applicationNumber,
                                    LoanRequestor loanRequestor) implements DomainEvent {
        public LoanApplicationSubmitted {
            if (modificationTime == null) modificationTime = LocalDateTime.now();
        }
    }

    @Builder
    record RequestForLoanStartSent(String modifiedBy, LocalDateTime modificationTime) implements DomainEvent {
        public RequestForLoanStartSent {
            if (modificationTime == null) modificationTime = LocalDateTime.now();
        }
    }

    @Builder
    record CommunicationAboutStartedLoanSent(LocalDateTime modificationTime,
                                             List<String> communicationType) implements DomainEvent {
    }
}
