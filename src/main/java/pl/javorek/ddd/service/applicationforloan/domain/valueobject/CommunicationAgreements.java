package pl.javorek.ddd.service.applicationforloan.domain.valueobject;

import jakarta.persistence.Embeddable;
import lombok.Builder;

@Builder
@Embeddable
public record CommunicationAgreements(boolean sms, boolean email) {
}
