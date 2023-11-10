package pl.javorek.ddd.service.applicationforloan.domain.valueobject;

import java.time.LocalDateTime;

public class ApplicationNumber {
    private String asString;

    public ApplicationNumber() {
        this.asString = "L" + LocalDateTime.now().toString();
    }
}
