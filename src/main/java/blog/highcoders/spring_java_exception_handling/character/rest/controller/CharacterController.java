package blog.highcoders.spring_java_exception_handling.character.rest.controller;

import blog.highcoders.spring_java_exception_handling.character.domain.Character;
import blog.highcoders.spring_java_exception_handling.character.domain.CharacterRepository;
import blog.highcoders.spring_java_exception_handling.character.domain.Role;
import blog.highcoders.spring_java_exception_handling.character.rest.dto.CharacterInput;
import blog.highcoders.spring_java_exception_handling.character.rest.dto.CharacterMapper;
import blog.highcoders.spring_java_exception_handling.character.rest.dto.CharacterOutput;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterRepository characterRepository;

    @PostMapping
    public ResponseEntity<Void> createCharacter(@Valid @RequestBody CharacterInput characterInput) {
        characterRepository.save(new Character(
                characterInput.name(),
                Role.valueOf(characterInput.role()),
                characterInput.level()
        ));
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CharacterOutput>> listCharacters() {
        List<Character> characters = (List<Character>) characterRepository.findAll();
        List<CharacterOutput> characterOutputs = characters.stream()
                .map(CharacterMapper::toCharacterOutput)
                .collect(Collectors.toList());
        return ResponseEntity.ok(characterOutputs);
    }
}
