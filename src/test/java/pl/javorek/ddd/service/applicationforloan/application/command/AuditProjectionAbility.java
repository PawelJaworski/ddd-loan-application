package pl.javorek.ddd.service.applicationforloan.application.command;

import pl.javorek.ddd.service.applicationforloan.application.persistence.AuditEntityRepositoryAbility;
import pl.javorek.ddd.service.applicationforloan.application.query.AuditProjection;

public interface AuditProjectionAbility {
    AuditProjection INSTANCE = AuditProjection.builder()
            .auditEntityRepository(AuditEntityRepositoryAbility.INSTANCE)
            .build();

    default AuditProjection getAuditProjection() {
        return INSTANCE;
    }
}