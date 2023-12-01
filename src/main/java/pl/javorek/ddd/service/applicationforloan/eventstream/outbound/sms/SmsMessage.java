package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms;

import java.time.LocalDateTime;

public record SmsMessage(LocalDateTime creationDate, String phoneNumber, String message) {
}
