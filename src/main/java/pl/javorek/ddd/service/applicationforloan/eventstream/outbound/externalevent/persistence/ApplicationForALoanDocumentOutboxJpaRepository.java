package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicationForALoanDocumentOutboxJpaRepository extends ApplicationForALoanDocumentOutboxRepository, JpaRepository<ApplicationForALoanDocumentOutbox, UUID> {
}
