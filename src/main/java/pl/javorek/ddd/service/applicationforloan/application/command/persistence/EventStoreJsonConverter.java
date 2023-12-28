package pl.javorek.ddd.service.applicationforloan.application.command.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.persistence.AttributeConverter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Slf4j
class EventStoreJsonConverter implements AttributeConverter<DomainEventJpaWrapper, String> {

  private final ObjectMapper objectMapper;

  public EventStoreJsonConverter(Jackson2ObjectMapperBuilder objectMapperBuilder) {
    objectMapperBuilder.modules(new JavaTimeModule());
    this.objectMapper = objectMapperBuilder.build();
  }

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
