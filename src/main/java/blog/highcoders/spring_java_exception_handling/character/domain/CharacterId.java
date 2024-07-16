package blog.highcoders.spring_java_exception_handling.character.domain;

import java.util.Objects;
import java.util.UUID;

public record CharacterId(UUID id) {
    public CharacterId {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("CharacterId id cannot be null");
        }
    }

    public CharacterId() {
        this(UUID.randomUUID());
    }
}