package pl.javorek.ddd.service.applicationforloan.application.persistence;

import pl.javorek.ddd.service.applicationforloan.application.command.persistence.EventStoreEntityRepository;

public interface EventStoreEntityRepositoryAbility {
    EventStoreEntityRepository INSTANCE = new EventStoreEntityInMemoryRepository();
}
