package pl.javorek.ddd.service.applicationforloan.application.command.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent;

import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DomainEventEntity {
    @Id
    private UUID id;

    @Convert(converter = EventStoreJsonConverter.class)
    @Column(length = 4064)
    private DomainEventJpaWrapper eventWrapper;

    public DomainEventEntity(DomainEvent domainEvent) {
        id = UUID.randomUUID();
        eventWrapper = new DomainEventJpaWrapper(domainEvent);
    }
}
