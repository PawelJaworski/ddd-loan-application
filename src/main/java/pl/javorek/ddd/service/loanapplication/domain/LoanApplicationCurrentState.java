package pl.javorek.ddd.service.loanapplication.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Builder
@Data
public class LoanApplicationCurrentState {
    private UUID id;
    private ApplicationNumberVo applicationNumber;
    private List<AttachedDocumentVo> attachedDocuments;
}
