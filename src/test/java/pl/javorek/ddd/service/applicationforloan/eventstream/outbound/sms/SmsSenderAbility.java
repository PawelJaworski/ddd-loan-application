package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms;

public interface SmsSenderAbility {
    SmsSender INSTANCE = SmsSender.builder()
            .smsOutboxRepository(SmsOutboxRepositoryAbility.INSTANCE)
            .build();

    default SmsSender getSmsSender() {
        return INSTANCE;
    }
}