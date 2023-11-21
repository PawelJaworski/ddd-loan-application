package pl.javorek.ddd.service.applicationforloan.infrastructure;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanStateRepository;
import pl.javorek.ddd.service.applicationforloan.domain.policy.ApplicationNumberPolicy;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;

@Component
@Builder
@RequiredArgsConstructor
public class ApplicationNumberDBPolicy implements ApplicationNumberPolicy {
    private final ApplicationForALoanStateRepository applicationForALoanStateRepository;

    @Override
    public ApplicationNumber getNextApplicationNumber() {
        return applicationForALoanStateRepository.findMaxApplicationNumberAsString()
                .map(it -> Integer.parseInt(it.replaceAll("\\D", "")))
                .map(it -> it + 1)
                .map(ApplicationNumber::new)
                .orElse(new ApplicationNumber(1));
    }
}
