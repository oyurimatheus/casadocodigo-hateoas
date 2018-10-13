package me.yurimatheus.casadocodigo.aplication;

import me.yurimatheus.casadocodigo.domain.publishinghouse.Book;
import me.yurimatheus.casadocodigo.domain.publishinghouse.repositories.BookRepository;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;
    private final Link link = linkTo(BookController.class).withSelfRel();

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(produces = "application/hal+json")
    public Resources<Book> list() {
        Iterable<Book> books = bookRepository.findAll();
        books.forEach(book -> book.add(book.getId()));

        return new Resources<>(books, link);
    }

    @GetMapping(value = "/{id}", produces = "application/hal+json")
    public Book book(@PathVariable("id") Long id) {
        Book book = bookRepository.findById(id);
        book.add(book.getId());

        return book;


    }

}
