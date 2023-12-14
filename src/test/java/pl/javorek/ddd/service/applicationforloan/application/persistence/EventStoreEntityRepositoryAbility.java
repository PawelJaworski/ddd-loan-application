package pl.javorek.ddd.service.applicationforloan.application.persistence;

public interface EventStoreEntityRepositoryAbility {
    EventStoreEntityRepository INSTANCE = new EventStoreEntityInMemoryRepository();
}
