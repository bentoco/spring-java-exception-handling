package blog.highcoders.spring_java_exception_handling.character.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "character_table")
public class Character {
    @EmbeddedId
    private CharacterId id;
    private String name;
    private Role role;
    private Integer level;

    public Character() {
    }

    public Character(String name, Role role, Integer level) {
        this.id = new CharacterId();
        this.name = name;
        this.role = role;
        this.level = level;
    }

    public CharacterId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public Integer getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(id, character.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
