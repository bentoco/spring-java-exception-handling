package blog.highcoders.spring_java_exception_handling.character.rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CharacterInput(
        @NotBlank(message = "Name cannot be null")
        String name,
        @Pattern(regexp = "SORCERER|KNIGHT|DRUID|PALADIN", message = "Invalid role")
        String role,
        @NotNull(message = "Level cannot be null")
        Integer level
) {}

