package pl.javorek.ddd.service.loanapplication.application.cmd;

import java.math.BigDecimal;

public record RequestForLoanCmd(String name, String lastName, BigDecimal loanAmount) {
}
