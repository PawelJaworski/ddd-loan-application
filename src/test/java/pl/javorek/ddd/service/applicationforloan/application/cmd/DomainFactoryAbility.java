package pl.javorek.ddd.service.applicationforloan.application.cmd;

import pl.javorek.ddd.service.applicationforloan.domain.ApplicationNumberPolicyAbility;
import pl.javorek.ddd.service.applicationforloan.domain.BankAgentPolicyAbility;

public interface DomainFactoryAbility {
    DomainFactory INSTANCE = DomainFactory.builder()
            .applicationNumberPolicy(ApplicationNumberPolicyAbility.INSTANCE)
            .bankAgentPolicy(BankAgentPolicyAbility.INSTANCE)
            .build();

    default DomainFactory getDomainFactory() {
        return INSTANCE;
    }
}