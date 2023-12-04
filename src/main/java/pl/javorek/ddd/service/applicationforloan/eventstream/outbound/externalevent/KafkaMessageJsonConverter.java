package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Converter;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbox.AbstractMessageJsonConverter;

@Converter
public class KafkaMessageJsonConverter extends AbstractMessageJsonConverter<KafkaMessage> {
    public KafkaMessageJsonConverter(ObjectMapper objectMapper) {
        super(objectMapper, KafkaMessage.class);
    }
}
