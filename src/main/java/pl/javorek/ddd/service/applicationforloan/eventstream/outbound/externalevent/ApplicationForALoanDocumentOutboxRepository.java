package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent;

import java.util.Optional;
import java.util.UUID;

public interface ApplicationForALoanDocumentOutboxRepository {
    ApplicationForALoanDocumentOutbox save(ApplicationForALoanDocumentOutbox entity);

    Optional<ApplicationForALoanDocumentOutbox> findById(UUID id);

    void deleteAll();
}
