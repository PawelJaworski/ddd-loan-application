package pl.javorek.ddd.service.applicationforloan.application.cmd;

import lombok.Builder;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocumentType;

import java.util.List;
import java.util.UUID;

@Builder
public record ProvideRequiredDocumentCmd(UUID id, AttachedDocumentType documentType) {
}
