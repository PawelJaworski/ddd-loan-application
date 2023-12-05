package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent;

import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.contract.ApplicationForALoanDocument;

import java.time.LocalDateTime;


public record KafkaMessage(LocalDateTime creationDate, ApplicationForALoanDocument message) {
}
