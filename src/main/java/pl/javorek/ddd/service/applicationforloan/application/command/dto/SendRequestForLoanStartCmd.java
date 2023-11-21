package pl.javorek.ddd.service.applicationforloan.application.command.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record SendRequestForLoanStartCmd(UUID id) {
}
