package me.yurimatheus.casadocodigo.domain.publishinghouse;

import me.yurimatheus.casadocodigo.domain.common.Title;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Table(name = "books")
@Entity
public class Book extends ResourceSupport {

    @Id @GeneratedValue
    private Long id;

    @Embedded
    private Title title;

    private LocalDate publishingDate;

    private String isbn;

    @ManyToMany(fetch = LAZY)
    private Set<Author> authors;

    public Book(Title title, LocalDate publishingDate, Set<Author> authors) {
        this.title = title;
        this.publishingDate = publishingDate;
        this.authors = authors;
    }

    /**
     * hibernate only
     */
    @Deprecated
    Book() {}

    public Book(Title title, LocalDate publishingDate, Author author) {
        this(title, publishingDate, Set.of(author));
    }

    public Link getId() {
        return linkTo(Book.class).slash("books").slash(id).withSelfRel();
    }

    public Long getBookId() {
        return id;
    }

    public Title getTitle() {
        return title;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public Set<Author> getAuthors() {
        return authors;
    }
}
