package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.javorek.ddd.service.applicationforloan.application.command.ApplicationForALoanCmdFacade
import pl.javorek.ddd.service.applicationforloan.application.command.ApplicationForALoanCmdFacadeAbility
import pl.javorek.ddd.service.applicationforloan.application.command.BankAgentPolicyAbility
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent.persistence.ApplicationForALoanDocumentOutboxRepository
import spock.lang.Specification

@SpringBootTest
class ExternalEventIntegrationTest extends Specification implements ApplicationForALoanCmdFacadeAbility, BankAgentPolicyAbility {

    @Autowired
    ApplicationForALoanCmdFacade applicationForALoanCmdFacade

    @Autowired
    ApplicationForALoanDocumentOutboxRepository kafkaOutboxRepository

    def setup() {
        log_as_bank_agent()
    }

    def "should send kafka document on proposal submitted"() {
        when:
        def id = loan_application_submitted()

        then:
        def outbox = kafkaOutboxRepository.findById(id).orElseThrow()
    }
}
