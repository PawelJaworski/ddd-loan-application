package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.outbox.SmsMessageJsonConverter;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SmsOutbox {
    @Id
    @Getter
    private UUID id;

    @Convert(converter = SmsMessageJsonConverter.class)
    private SmsMessage message;
}
