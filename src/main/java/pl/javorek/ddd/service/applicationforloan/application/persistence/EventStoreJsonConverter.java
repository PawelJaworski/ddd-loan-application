package pl.javorek.ddd.service.applicationforloan.application.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import pl.javorek.ddd.service.applicationforloan.domain.DomainEvent;

@RequiredArgsConstructor
@Slf4j
public class EventStoreJsonConverter implements AttributeConverter<DomainEventJpaWrapper, String> {

  private final ObjectMapper objectMapper;

  @SneakyThrows
  @Override
  public String convertToDatabaseColumn(DomainEventJpaWrapper attribute) {
    return objectMapper.writeValueAsString(attribute);
  }

  @Override
  public DomainEventJpaWrapper convertToEntityAttribute(String dbData) {
    try {
      return objectMapper.readValue(dbData, DomainEventJpaWrapper.class);
    } catch (JsonProcessingException e) {
      log.error("{}", e, e);
      return null;
    }
  }
}
