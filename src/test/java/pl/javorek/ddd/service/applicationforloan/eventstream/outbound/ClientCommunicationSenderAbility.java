package pl.javorek.ddd.service.applicationforloan.eventstream.outbound;

import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms.SmsSender;

public interface ClientCommunicationSenderAbility {
    SmsSender INSTANCE = SmsSender.builder().build();

    default SmsSender getClientCommunicationSender() {
        return INSTANCE;
    }
}