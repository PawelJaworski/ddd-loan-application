package pl.javorek.ddd.service.applicationforloan.application.readmodel;

import jakarta.persistence.*;
import lombok.*;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocument;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoanApplicationState {
    @Id
    private UUID id;

    @Embedded
    private ApplicationNumber applicationNumber;

    @ElementCollection
    @OrderColumn
    private List<AttachedDocument> attachedDocuments;

    public LoanApplicationState(UUID id) {
        this.id = id;
    }
}
