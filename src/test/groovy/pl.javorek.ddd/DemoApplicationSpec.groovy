package pl.javorek.ddd

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class DemoApplicationSpec extends Specification {
    def "should load context"() {
        expect:
        true
    }
}
