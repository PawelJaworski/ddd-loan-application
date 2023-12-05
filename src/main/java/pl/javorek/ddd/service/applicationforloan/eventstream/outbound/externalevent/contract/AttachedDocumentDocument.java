package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.contract;

import pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocumentType;

public record AttachedDocumentDocument(AttachedDocumentType type) {
}
