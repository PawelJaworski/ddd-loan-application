package pl.javorek.ddd.service.applicationforloan.application.cmd;

public interface DomainFactoryAbility {
    DomainFactory INSTANCE = new DomainFactory();

    default DomainFactory getDomainFactory() {
        return INSTANCE;
    }
}