package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.contract;

public record LoanRequestorDocument(String name, String lastName, String phoneNumber) {
}
