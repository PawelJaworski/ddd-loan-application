package pl.javorek.ddd.service.applicationforloan.application.persistence;

import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;

import java.util.*;

public class ApplicationForALoanStateInMemoryRepository implements ApplicationForALoanStateRepository {
    private final Map<UUID, ApplicationForALoanState> data = new HashMap<>();

    @Override
    public ApplicationForALoanState save(ApplicationForALoanState entity) {
        data.put(entity.getId(), entity);

        return entity;
    }

    @Override
    public Optional<ApplicationForALoanState> findOneById(UUID id) {
        return data.values().stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<String> findMaxApplicationNumberAsString() {
        return data.values().stream()
                .map(ApplicationForALoanState::getApplicationNumber)
                .map(ApplicationNumber::getAsString)
                .max(Comparator.naturalOrder());
    }


}
