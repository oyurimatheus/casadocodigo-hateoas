package me.yurimatheus.casadocodigo.domain.publishinghouse;

import me.yurimatheus.casadocodigo.domain.common.Name;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Table(name = "authors")
@Entity
public class Author extends ResourceSupport {

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
    public Link getId() {
        return linkTo(Author.class).slash("authors").slash(id).withSelfRel();
    }

    public Long getAuthorId() {
        return id;
    }

    public Name getName() {
        return name;
    }

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
