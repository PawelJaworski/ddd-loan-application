package pl.javorek.ddd.service.applicationforloan.application.command.persistence;

import jakarta.persistence.*;
import lombok.*;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApplicationForALoanEntity {
    @Id
    private UUID id;

    @Embedded
    private ApplicationNumber applicationNumber;

    @Embedded
    private LoanRequestor loanRequestor;

    @ElementCollection
    @OrderColumn
    @Setter(AccessLevel.NONE)
    private List<AttachedDocument> attachedDocuments = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private ApplicationStatusType applicationStatus;

    private CommunicationAgreements communicationAgreements;

    public ApplicationForALoanEntity(UUID id) {
        this.id = id;
    }

    public void addDocument(AttachedDocument document) {
        attachedDocuments.add(document);
    }
}
