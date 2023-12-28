package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Converter;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.contract.ApplicationForALoanDocument;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.util.AbstractMessageJsonConverter;

@Converter
public class ApplicationForALoanDocumentJsonConverter extends AbstractMessageJsonConverter<ApplicationForALoanDocument> {
    public ApplicationForALoanDocumentJsonConverter(ObjectMapper objectMapper) {
        super(objectMapper, ApplicationForALoanDocument.class);
    }
}
