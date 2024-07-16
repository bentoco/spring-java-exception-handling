package blog.highcoders.spring_java_exception_handling.character.rest.dto;

import blog.highcoders.spring_java_exception_handling.character.domain.Character;

public class CharacterMapper {
    public static CharacterOutput toCharacterOutput(Character character) {
        return new CharacterOutput(
                character.getId().id(),
                character.getName(),
                character.getRole().name(),
                character.getLevel()
        );
    }
}
