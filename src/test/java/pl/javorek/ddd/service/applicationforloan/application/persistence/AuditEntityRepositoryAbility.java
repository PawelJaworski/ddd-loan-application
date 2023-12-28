package pl.javorek.ddd.service.applicationforloan.application.persistence;

import pl.javorek.ddd.service.applicationforloan.application.query.persistence.AuditEntityRepository;

public interface AuditEntityRepositoryAbility {
    AuditEntityRepository INSTANCE = new AuditEntityInMemoryRepository();

    default AuditEntityRepository getAuditEntityRepository() {
        return INSTANCE;
    }
}