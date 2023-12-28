package pl.javorek.ddd.service.applicationforloan.application.persistence;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    private List<DomainEventEntity> domainEvents = new ArrayList<>();

    public EventStoreEntity(UUID id, DomainEvent domainEvent) {
        this.id = id;
        this.addEvent(domainEvent);
    }

    public void addEvent(DomainEvent domainEvent) {
        domainEvents.add(new DomainEventEntity(domainEvent));
    }
}
