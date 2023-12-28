package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms.contract;

import java.time.LocalDateTime;

public record SmsMessage(LocalDateTime creationDate, String phoneNumber, String message) {
}
