package pl.javorek.ddd.service.applicationforloan.application.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AuditEntity {
    @Id
    private UUID id;

    private String bankAgentReceivingRequestForALoan;
}
