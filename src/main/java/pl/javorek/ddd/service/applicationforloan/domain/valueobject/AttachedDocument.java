package pl.javorek.ddd.service.applicationforloan.domain.valueobject;

import jakarta.persistence.Embeddable;
import lombok.*;

@Builder
@Embeddable
public record AttachedDocument(AttachedDocumentType type) {
}
