package pl.javorek.ddd.service.applicationforloan.application.cmd;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record RequestForALoanCmd(String name, String lastName, BigDecimal loanAmount) {
}
