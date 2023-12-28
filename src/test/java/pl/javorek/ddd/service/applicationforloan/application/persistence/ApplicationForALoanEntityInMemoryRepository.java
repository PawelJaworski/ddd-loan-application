package pl.javorek.ddd.service.applicationforloan.application.persistence;

import pl.javorek.ddd.service.applicationforloan.application.command.persistence.ApplicationForALoanEntity;
import pl.javorek.ddd.service.applicationforloan.application.command.persistence.ApplicationForALoanEntityRepository;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;

import java.util.*;

public class ApplicationForALoanEntityInMemoryRepository implements ApplicationForALoanEntityRepository {
    private final Map<UUID, ApplicationForALoanEntity> data = new HashMap<>();

    @Override
    public ApplicationForALoanEntity save(ApplicationForALoanEntity entity) {
        data.put(entity.getId(), entity);

        return entity;
    }

    @Override
    public Optional<ApplicationForALoanEntity> findOneById(UUID id) {
        return data.values().stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<ApplicationForALoanEntity> findOneByApplicationNumberAsString(String applicationNumber) {
        return data.values().stream()
                .filter(it -> it.getApplicationNumber().getAsString().equals(applicationNumber))
                .findFirst();
    }

    @Override
    public Optional<String> findMaxApplicationNumberAsString() {
        return data.values().stream()
                .map(ApplicationForALoanEntity::getApplicationNumber)
                .map(ApplicationNumber::getAsString)
                .max(Comparator.naturalOrder());
    }


}
