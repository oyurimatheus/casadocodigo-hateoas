package me.yurimatheus.casadocodigo.domain.publishinghouse;

import me.yurimatheus.casadocodigo.domain.common.Name;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Table(name = "authors")
@Entity
public class Author {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Embedded
    private Name name;

    public Author(Name name) {
        this.name = name;
    }

    /**
     * hibernate only
     */
    @Deprecated
    Author() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
