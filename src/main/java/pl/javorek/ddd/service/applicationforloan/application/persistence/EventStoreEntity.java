package pl.javorek.ddd.service.applicationforloan.application.persistence;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EventStoreEntity {

    @Id
    @Getter
    private UUID id;

    @Convert(converter = EventStoreJsonConverter.class)
    private List<DomainEventJpaWrapper> domainEvents = new ArrayList<>();

    public EventStoreEntity(UUID id) {
        this.id = id;
    }

    public void addEvent(DomainEvent domainEvent) {
        domainEvents.add(new DomainEventJpaWrapper(domainEvent));
    }
}
