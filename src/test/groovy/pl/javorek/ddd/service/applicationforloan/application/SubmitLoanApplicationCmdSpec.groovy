package pl.javorek.ddd.service.applicationforloan.application

import pl.javorek.ddd.service.applicationforloan.application.cmd.ApplicationForALoanCmdFacadeAbility
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanStateRepositoryAbility
import pl.javorek.ddd.service.applicationforloan.domain.BankAgentPolicyAbility
import spock.lang.Specification

import static pl.javorek.ddd.service.applicationforloan.domain.valueobject.ApplicationStatusType.DRAFT

class SubmitLoanApplicationCmdSpec extends Specification implements ApplicationForALoanCmdFacadeAbility,
        ApplicationForALoanStateRepositoryAbility, BankAgentPolicyAbility {

    def setup() {
        log_as_bank_agent()
    }

    def "When application a loan submitted then loan request saved and got unique id."() {
        when:
        var id = loan_application_submitted()

        then:
        expect_application_for_a_loan_is_saved(id)
    }

    def "When application for a loan subbmited then loan request gets request number."() {
        when:
        var id = loan_application_submitted()

        then:
        expect_loan_application_number_is_assigned(id)
    }

    def "When request for a loan submitted then application status is DRAFT."() {
        when:
        var id = loan_application_submitted()

        then:
        expect_application_status_is(id, DRAFT)
    }
}
