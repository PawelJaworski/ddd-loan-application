package pl.javorek.ddd.service.applicationforloan.application.command;

public interface AuditProjectionAbility {
    AuditProjection INSTANCE = AuditProjection.builder().build();

    default AuditProjection getAuditProjection() {
        return INSTANCE;
    }
}