package pl.javorek.ddd.service.applicationforloan.application.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public record AuditEntity(@Id UUID id) {

}
