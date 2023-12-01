package pl.javorek.ddd.service.applicationforloan.application.persistence;

import org.junit.jupiter.api.Assertions;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationNumber;
import pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationStatusType;

import java.util.Optional;
import java.util.UUID;

public interface ApplicationForALoanEntityRepositoryAbility {
    ApplicationForALoanEntityRepository INSTANCE = new ApplicationForALoanEntityInMemoryRepository();

    default void expect_application_for_a_loan_is_saved(UUID id) {
      var found = getApplicationForALoanEntityRepository().findOneById(id);

      Assertions.assertTrue(found.isPresent(), "Application for a loan with id " + id + " not found.");
    }

    default void expect_loan_application_number_is_assigned(UUID id) {
        var actual = getApplicationForALoanEntityRepository().findOneById(id)
                .orElseThrow()
                .getApplicationNumber()
                .getAsString();

        Assertions.assertFalse(actual.isBlank());
    }

    default void expect_application_status_is(UUID id, ApplicationStatusType expected) {
        var actual = getApplicationForALoanEntityRepository().findOneById(id)
                .orElseThrow()
                .getApplicationStatus();

        Assertions.assertEquals(actual, expected);
    }

    default void expect_waiting_for_approval(UUID id) {
        var actual = getApplicationForALoanEntityRepository().findOneById(id)
                .orElseThrow()
                .getApplicationStatus();

        Assertions.assertEquals(ApplicationStatusType.WAITING_FOR_APPROVAL, actual);
    }

    default Optional<String> with_loan_application_number(UUID id) {
        return getApplicationForALoanEntityRepository().findOneById(id)
                .map(ApplicationForALoanEntity::getApplicationNumber)
                .map(ApplicationNumber::getAsString);
    }

    default ApplicationForALoanEntityRepository getApplicationForALoanEntityRepository() {
        return INSTANCE;
    }
}
