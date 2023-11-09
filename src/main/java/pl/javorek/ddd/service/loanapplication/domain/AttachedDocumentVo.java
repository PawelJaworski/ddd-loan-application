package pl.javorek.ddd.service.loanapplication.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@Builder
public class AttachedDocumentVo {
    private AttachedDocumentType type;
    private String location;
    private LocalDate validFrom;
    private LocalDate validTo;
}
