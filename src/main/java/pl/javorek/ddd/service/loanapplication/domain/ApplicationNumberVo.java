package pl.javorek.ddd.service.loanapplication.domain;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

public class ApplicationNumberVo {
    private String asString;

    public ApplicationNumberVo() {
        this.asString = "L" + LocalDateTime.now().toString();
    }
}
