package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent;

import java.time.LocalDateTime;

public record KafkaMessage(LocalDateTime creationDate, String message) {
}
