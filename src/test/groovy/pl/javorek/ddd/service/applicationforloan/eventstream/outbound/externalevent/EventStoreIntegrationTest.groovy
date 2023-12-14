package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.externalevent

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.javorek.ddd.service.applicationforloan.application.command.ApplicationForALoanCmdFacade
import pl.javorek.ddd.service.applicationforloan.application.command.ApplicationForALoanCmdFacadeAbility
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntityRepositoryAbility
import pl.javorek.ddd.service.applicationforloan.application.persistence.EventStoreEntityRepository
import pl.javorek.ddd.service.applicationforloan.application.persistence.EventStoreEntityRepositoryAbility
import pl.javorek.ddd.service.applicationforloan.domain.BankAgentPolicyAbility
import spock.lang.Specification

@SpringBootTest
class EventStoreIntegrationTest extends Specification implements ApplicationForALoanCmdFacadeAbility,
        EventStoreEntityRepositoryAbility, BankAgentPolicyAbility, ApplicationForALoanEntityRepositoryAbility {

    @Autowired
    ApplicationForALoanCmdFacade applicationForALoanCmdFacade

    @Autowired
    EventStoreEntityRepository eventStoreEntityRepository

    def "should work"() {
        when:
        log_as_bank_agent()
        def id = loan_application_submitted{
            it.smsAgreement(false)
        }

        with_loan_application_number(id)
                .ifPresent { communication_about_started_loan_sent(it) }

        then:
        true
    }
}
