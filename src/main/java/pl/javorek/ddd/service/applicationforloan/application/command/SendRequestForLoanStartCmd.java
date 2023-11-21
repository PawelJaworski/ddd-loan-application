package pl.javorek.ddd.service.applicationforloan.application.command;

import lombok.Builder;

import java.util.UUID;

@Builder
public record SendRequestForLoanStartCmd(UUID id) {
}
