package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class KafkaOutbox {
    @Id
    @Getter
    private UUID id;

    @Convert(converter = KafkaMessageJsonConverter.class)
    private KafkaMessage message;
}
