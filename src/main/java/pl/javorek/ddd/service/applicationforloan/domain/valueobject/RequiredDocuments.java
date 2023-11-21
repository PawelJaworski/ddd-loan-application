package pl.javorek.ddd.service.applicationforloan.domain.valueobject;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static pl.javorek.ddd.service.applicationforloan.domain.valueobject.AttachedDocumentType.*;

public final class RequiredDocuments {
    private static Set<AttachedDocumentType> REQUIRED_DOCUMENT_TYPES = Set.of(EMPLOYMENT_CERTIFICATE,
            BANK_ACCOUNT_STATEMENT, GDPR);
    private final Set<AttachedDocumentType> attachedDocumentTypes;

    public RequiredDocuments() {
        this(List.of());
    }

    public RequiredDocuments(List<AttachedDocument> attachedDocuments)  {
        attachedDocumentTypes = attachedDocuments.stream()
                .map(AttachedDocument::type).collect(Collectors.toSet());
    }

    public boolean isAllRequiredDocumentsProvided() {
        return attachedDocumentTypes.containsAll(REQUIRED_DOCUMENT_TYPES);
    }
}
