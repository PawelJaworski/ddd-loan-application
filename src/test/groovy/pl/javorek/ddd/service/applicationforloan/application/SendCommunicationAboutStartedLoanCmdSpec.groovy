package pl.javorek.ddd.service.applicationforloan.application

import pl.javorek.ddd.service.applicationforloan.application.command.ApplicationForALoanCmdFacadeAbility
import pl.javorek.ddd.service.applicationforloan.application.persistence.ApplicationForALoanEntityRepositoryAbility
import pl.javorek.ddd.service.applicationforloan.domain.BankAgentPolicyAbility
import pl.javorek.ddd.service.applicationforloan.eventstream.outbound.sms.SmsOutboxRepositoryAbility
import spock.lang.Specification

class SendCommunicationAboutStartedLoanCmdSpec extends Specification implements ApplicationForALoanCmdFacadeAbility,
        ApplicationForALoanEntityRepositoryAbility, BankAgentPolicyAbility, SmsOutboxRepositoryAbility {

    def "Should sent sms communication when sms agreement."() {
        given:
        log_as_bank_agent()
        def id = loan_application_submitted{
            it.smsAgreement(smsAgreement)
        }

        when:
        with_loan_application_number(id)
                .ifPresent { communication_about_started_loan_sent(it) }

        then:
        with_sms_sent(id).isPresent() == smsAgreement

        where:
        smsAgreement << [true, false]
    }
}
