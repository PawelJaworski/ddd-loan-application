package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import pl.javorek.ddd.service.applicationforloan.application.command.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.contract.ApplicationForALoanDocument;

import java.util.Optional;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ApplicationForALoanDocumentMapper {
    ApplicationForALoanDocument map(ApplicationForALoanEntity entity);

    default String mapApplicationNumber(ApplicationNumber applicationNumber) {
        return Optional.ofNullable(applicationNumber)
                .map(ApplicationNumber::getAsString)
                .orElse(null);
    }
}
