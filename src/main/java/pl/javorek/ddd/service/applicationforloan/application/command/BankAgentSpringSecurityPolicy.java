package pl.javorek.ddd.service.applicationforloan.application.command;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.domain.policy.BankAgentPolicy;

@Component
class BankAgentSpringSecurityPolicy implements BankAgentPolicy {
    @Override
    public String getUsername() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();
    }
}
