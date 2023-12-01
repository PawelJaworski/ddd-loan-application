package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.converter.SmsMessageJsonConverter;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms.SmsMessage;

import java.util.UUID;

@Entity
public class SmsOutbox {
    @Id
    private UUID id;

    @Convert(converter = SmsMessageJsonConverter.class)
    private SmsMessage message;
}
