package pl.javorek.ddd.service.applicationforloan.application.readmodel;

import jakarta.persistence.*;
import lombok.*;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationStatusType;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocument;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ApplicationForALoanState {
    @Id
    private UUID id;

    @Embedded
    private ApplicationNumber applicationNumber;

    @ElementCollection
    @OrderColumn
    @Setter(AccessLevel.NONE)
    private List<AttachedDocument> attachedDocuments = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private ApplicationStatusType applicationStatus;

    public ApplicationForALoanState(UUID id) {
        this.id = id;
    }

    public void addDocument(AttachedDocument document) {
        attachedDocuments.add(document);
    }
}
