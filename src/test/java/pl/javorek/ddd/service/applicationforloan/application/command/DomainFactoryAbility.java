package pl.javorek.ddd.service.applicationforloan.application.command;

public interface DomainFactoryAbility {
    DomainFactory INSTANCE = DomainFactory.builder()
            .applicationNumberPolicy(ApplicationNumberPolicyAbility.INSTANCE)
            .bankAgentPolicy(BankAgentPolicyAbility.INSTANCE)
            .build();

    default DomainFactory getDomainFactory() {
        return INSTANCE;
    }
}
