package pl.javorek.ddd.service.applicationforloan.application.outbound;

public interface EmailPublisherAbility {
    EmailPublisher INSTANCE = new EmailPublisher();

    default EmailPublisher getEmailPublisher() {
        return INSTANCE;
    }
}
