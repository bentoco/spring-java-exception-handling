package blog.highcoders.spring_java_exception_handling.character.domain;

import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Character, CharacterId> {}
