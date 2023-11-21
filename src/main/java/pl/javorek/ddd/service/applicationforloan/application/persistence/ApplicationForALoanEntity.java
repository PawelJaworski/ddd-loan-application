package pl.javorek.ddd.service.applicationforloan.application.persistence;

import jakarta.persistence.*;
import lombok.*;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationStatusType;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocument;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.LoanRequestor;

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

    public ApplicationForALoanEntity(UUID id) {
        this.id = id;
    }

    public void addDocument(AttachedDocument document) {
        attachedDocuments.add(document);
    }
}
