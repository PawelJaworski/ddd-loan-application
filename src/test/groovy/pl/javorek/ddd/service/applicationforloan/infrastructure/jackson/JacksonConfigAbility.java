package pl.javorek.ddd.service.applicationforloan.infrastructure.jackson;

public interface JacksonConfigAbility {
    JacksonConfig INSTANCE = new JacksonConfig();

    default JacksonConfig getJacksonConfig() {
        return INSTANCE;
    }
}