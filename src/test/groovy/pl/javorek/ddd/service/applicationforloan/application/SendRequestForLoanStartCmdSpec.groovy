package pl.javorek.ddd.service.applicationforloan.application

import pl.javorek.ddd.service.applicationforloan.application.cmd.ApplicationForALoanCmdFacadeAbility
import pl.javorek.ddd.service.applicationforloan.domain.error.ApplicationForALoanException
import spock.lang.Specification

class SendRequestForLoanStartCmdSpec extends Specification implements ApplicationForALoanCmdFacadeAbility {

    def "When send request for loan given not all required documents sent then error raised"() {
        given:
        def id = loan_application_submitted()

        when:
        request_for_loan_start_sent(id)

        then:
        def ex = thrown(ApplicationForALoanException)
        ex.message == "send-request-for-loan-start.error.not-all-required-documents-provided"
    }
}
