package pl.javorek.ddd.service.applicationforloan.domain.valueobject;

import lombok.Builder;

@Builder
public record LoanRequestor(String name, String lastName, String phoneNumber,
                            CommunicationAgreements communicationAgreements) {
}
