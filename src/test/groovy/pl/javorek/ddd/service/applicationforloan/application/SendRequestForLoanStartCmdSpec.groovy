package pl.javorek.ddd.service.applicationforloan.application

import pl.javorek.ddd.service.applicationforloan.application.cmd.ApplicationForALoanCmdFacadeAbility
import pl.javorek.ddd.service.applicationforloan.application.readmodel.ApplicationForALoanStateRepositoryAbility
import pl.javorek.ddd.service.applicationforloan.domain.error.ApplicationForALoanException
import spock.lang.Specification

class SendRequestForLoanStartCmdSpec extends Specification implements ApplicationForALoanCmdFacadeAbility,
        ApplicationForALoanStateRepositoryAbility {

    def "When send request for loan given not all required documents provided then error raised"() {
        given:
        def id = loan_application_submitted()

        when:
        request_for_loan_start_sent(id)

        then:
        def ex = thrown(ApplicationForALoanException)
        ex.message == "send-request-for-loan-start.error.not-all-required-documents-provided"
    }

    def "When send request for loan given all required documents provided then WAITING_FOR_APPROVAL."() {
        given:
        def id = loan_application_submitted()
        all_required_documents_provided(id)

        when:
        request_for_loan_start_sent(id)

        then:
        expect_waiting_for_approval(id);
    }
}
