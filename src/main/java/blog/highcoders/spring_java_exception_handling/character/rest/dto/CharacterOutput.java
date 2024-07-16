package blog.highcoders.spring_java_exception_handling.character.rest.dto;

import java.util.UUID;

public record CharacterOutput(
        UUID id,
        String name,
        String role,
        Integer level
) {}
