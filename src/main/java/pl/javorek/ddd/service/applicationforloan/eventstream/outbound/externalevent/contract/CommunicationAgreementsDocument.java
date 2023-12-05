package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.contract;

public record CommunicationAgreementsDocument(boolean sms, boolean email) {
}
