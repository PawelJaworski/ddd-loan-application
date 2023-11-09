package pl.javorek.ddd.service.loanapplication.domain;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class LoanApplicationCurrentState {
    private UUID id;
    private ApplicationNumberVo applicationNumber;
    private List<AttachedDocumentVo> attachedDocuments;
}
