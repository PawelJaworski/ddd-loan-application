package pl.javorek.ddd.service.applicationforloan.domain.valueobject;

import lombok.Getter;

import java.time.LocalDateTime;

public class ApplicationNumber {
    @Getter
    private String asString;

    public ApplicationNumber() {
        this.asString = "L" + LocalDateTime.now().toString();
    }
}
