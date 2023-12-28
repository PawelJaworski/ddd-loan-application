package pl.javorek.ddd.service.applicationforloan.eventstream.outbound.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public abstract class AbstractMessageJsonConverter<T> implements AttributeConverter<T, String> {

  private final ObjectMapper objectMapper;
  private final Class<T> clazz;

  @SneakyThrows
  @Override
  public String convertToDatabaseColumn(T attribute) {
    return objectMapper.writeValueAsString(attribute);
  }

  @Override
  public T convertToEntityAttribute(String dbData) {
    try {
      return objectMapper.readValue(dbData, clazz);
    } catch (JsonProcessingException e) {
      log.error("{}", e, e);
      return null;
    }
  }
}
