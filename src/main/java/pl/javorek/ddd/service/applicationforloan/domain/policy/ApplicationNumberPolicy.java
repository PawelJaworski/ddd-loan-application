package pl.javorek.ddd.service.applicationforloan.domain.policy;

import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;

public interface ApplicationNumberPolicy {
    ApplicationNumber getNextApplicationNumber();
}
