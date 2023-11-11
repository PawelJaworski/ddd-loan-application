package pl.javorek.ddd.service.applicationforloan.domain.event;

import lombok.Builder;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.LoanRequestor;

import java.time.LocalDateTime;
import java.util.UUID;

public sealed interface DomainEvent {
    String modifiedBy();
    LocalDateTime modificationTime();

    @Builder
    record LoanRequested(String modifiedBy, LocalDateTime modificationTime, ApplicationNumber applicationNumber,
                         LoanRequestor loanRequestor) implements DomainEvent {
        public LoanRequested {
            if (modificationTime == null) modificationTime = LocalDateTime.now();
        }
    }
}
