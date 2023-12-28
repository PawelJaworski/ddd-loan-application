package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Converter;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.util.AbstractMessageJsonConverter;

@Converter
public class SmsMessageJsonConverter extends AbstractMessageJsonConverter<SmsMessage> {
    public SmsMessageJsonConverter(ObjectMapper objectMapper) {
        super(objectMapper, SmsMessage.class);
    }
}
