package pl.javorek.ddd.service.applicationforloan.domain.valueobject;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@Builder
@Embeddable
public class AttachedDocument {
    private AttachedDocumentType type;
}
