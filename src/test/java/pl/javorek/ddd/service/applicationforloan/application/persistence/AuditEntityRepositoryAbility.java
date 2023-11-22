package pl.javorek.ddd.service.applicationforloan.application.persistence;

public interface AuditEntityRepositoryAbility {
    AuditEntityRepository INSTANCE = new AuditEntityInMemoryRepository();

    default AuditEntityRepository getAuditEntityRepository() {
        return INSTANCE;
    }
}