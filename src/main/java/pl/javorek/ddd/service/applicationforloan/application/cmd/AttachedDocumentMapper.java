package pl.javorek.ddd.service.applicationforloan.application.cmd;

import pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocument;

public interface AttachedDocumentMapper {

    default AttachedDocument map(ProvideRequiredDocumentCmd cmd) {
        return AttachedDocument.builder()
                .type(cmd.documentType())
                .build();
    }
}
