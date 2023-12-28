package pl.javorek.ddd.service.applicationforloan.application.command;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.command.persistence.ApplicationForALoanEntityRepository;
import pl.javorek.ddd.service.applicationforloan.domain.policy.ApplicationNumberPolicy;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;

@Component
@Builder
@RequiredArgsConstructor
class ApplicationNumberDBPolicy implements ApplicationNumberPolicy {
    private final ApplicationForALoanEntityRepository applicationForALoanEntityRepository;

    @Override
    public ApplicationNumber getNextApplicationNumber() {
        return applicationForALoanEntityRepository.findMaxApplicationNumberAsString()
                .map(it -> Integer.parseInt(it.replaceAll("\\D", "")))
                .map(it -> it + 1)
                .map(ApplicationNumber::new)
                .orElse(new ApplicationNumber(1));
    }
}
