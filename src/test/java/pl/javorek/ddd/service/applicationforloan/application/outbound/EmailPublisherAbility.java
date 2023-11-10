package pl.javorek.ddd.service.applicationforloan.application.outbound;

import pl.javorek.ddd.service.applicationforloan.application.integration.EmailPublisher;

public interface EmailPublisherAbility {
    EmailPublisher INSTANCE = new EmailPublisher();

    default EmailPublisher getEmailPublisher() {
        return INSTANCE;
    }
}
