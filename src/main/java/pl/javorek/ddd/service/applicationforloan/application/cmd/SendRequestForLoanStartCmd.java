package pl.javorek.ddd.service.applicationforloan.application.cmd;

import lombok.Builder;

import java.util.UUID;

@Builder
public record SendRequestForLoanStartCmd(UUID id) {
}
