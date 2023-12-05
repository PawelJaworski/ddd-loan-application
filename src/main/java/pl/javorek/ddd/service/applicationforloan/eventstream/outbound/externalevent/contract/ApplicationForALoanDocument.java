package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.contract;

import java.util.List;
import java.util.UUID;

public record ApplicationForALoanDocument(UUID id, String applicationNumber, LoanRequestorDocument loanRequestor,
                                          List<AttachedDocumentDocument> attachedDocuments, String applicationStatus,
                                          CommunicationAgreementsDocument communicationAgreements) {
}
