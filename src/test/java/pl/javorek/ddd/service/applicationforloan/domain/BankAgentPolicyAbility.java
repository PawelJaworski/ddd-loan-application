package pl.javorek.ddd.service.applicationforloan.domain;

import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.javorek.ddd.service.applicationforloan.domain.policy.BankAgentPolicy;
import pl.javorek.ddd.service.applicationforloan.application.config.BankAgentSpringSecurityPolicy;

public interface BankAgentPolicyAbility {
    BankAgentSpringSecurityPolicy INSTANCE = new BankAgentSpringSecurityPolicy();
    String BANK_AGENT_USERNAME = "bank_agent_username";

    default void log_as_bank_agent() {
      SecurityContextHolder.getContext().setAuthentication(new TestingAuthenticationToken(BANK_AGENT_USERNAME, BANK_AGENT_USERNAME));
    }

    default BankAgentPolicy getBankAgentPolicy() {
        return INSTANCE;
    }
}