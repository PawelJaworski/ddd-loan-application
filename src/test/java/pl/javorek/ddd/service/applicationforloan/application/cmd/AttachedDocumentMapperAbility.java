package pl.javorek.ddd.service.applicationforloan.application.cmd;

import pl.javorek.ddd.service.applicationforloan.infrastructure.AttachedDocumentMapperImpl;

public interface AttachedDocumentMapperAbility {
    AttachedDocumentMapper INSTANCE = new AttachedDocumentMapperImpl();
}
