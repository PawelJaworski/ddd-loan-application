package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.contract.ApplicationForALoanDocument;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class KafkaOutbox {
    @Id
    @Getter
    private UUID id;

    @Column(length = 4064)
    @Convert(converter = ApplicationForALoanDocumentJsonConverter.class)
    private ApplicationForALoanDocument message;
}
