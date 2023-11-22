package pl.javorek.ddd.service.applicationforloan.application.query;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.command.DomainEventListener;
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.application.persistence.AuditEntity;
import pl.javorek.ddd.service.applicationforloan.application.persistence.AuditEntityRepository;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent;

@Component
@Builder
@RequiredArgsConstructor
public class AuditProjection implements DomainEventListener {

    private final AuditEntityRepository auditEntityRepository;

    @Override
    public void onDomainEvent(DomainEvent event, ApplicationForALoanEntity entity) {

        if (event instanceof DomainEvent.LoanApplicationSubmitted loanApplicationSubmitted) {
            onLoanApplicationSubmitted(loanApplicationSubmitted, entity);
        }
    }

    private void onLoanApplicationSubmitted(DomainEvent.LoanApplicationSubmitted event, ApplicationForALoanEntity entity) {
        var audit = AuditEntity.builder()
                .id(entity.getId())
                .bankAgentReceivingRequestForALoan(event.modifiedBy())
                .build();
        auditEntityRepository.save(audit);
    }

}
