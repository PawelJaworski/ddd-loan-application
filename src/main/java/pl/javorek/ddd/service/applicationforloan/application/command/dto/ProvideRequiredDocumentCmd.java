package pl.javorek.ddd.service.applicationforloan.application.command.dto;

import lombok.Builder;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocumentType;

import java.util.UUID;

@Builder
public record ProvideRequiredDocumentCmd(UUID id, AttachedDocumentType documentType) {
}
