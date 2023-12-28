package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.javorek.ddd.service.applicationforloan.application.command.ApplicationForALoanCmdFacade
import pl.javorek.ddd.service.applicationforloan.application.command.ApplicationForALoanCmdFacadeAbility
import pl.javorek.ddd.service.applicationforloan.application.command.BankAgentPolicyAbility
import spock.lang.Specification

@SpringBootTest
class ExternalEventIntegrationTest extends Specification implements ApplicationForALoanCmdFacadeAbility, BankAgentPolicyAbility {

    @Autowired
    ApplicationForALoanCmdFacade applicationForALoanCmdFacade

    def setup() {
        log_as_bank_agent()
    }

    def "should send kafka document on proposal submitted"() {
        when:
        def id = loan_application_submitted()

        then:
        true

    }
}
