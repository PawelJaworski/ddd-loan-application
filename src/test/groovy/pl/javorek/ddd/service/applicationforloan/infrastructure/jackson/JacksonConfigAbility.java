package pl.javorek.ddd.service.applicationforloan.infrastructure.jackson;

import pl.javorek.ddd.service.applicationforloan.infrastructure.JacksonConfig;

public interface JacksonConfigAbility {
    JacksonConfig INSTANCE = new JacksonConfig();

    default JacksonConfig getJacksonConfig() {
        return INSTANCE;
    }
}