package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.outbox;

public interface ApplicationForALoanOutbox<T> {
    String messageType();

    T payload();
}
