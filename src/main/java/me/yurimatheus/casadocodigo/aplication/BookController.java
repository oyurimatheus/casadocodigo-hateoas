package me.yurimatheus.casadocodigo.aplication;

import me.yurimatheus.casadocodigo.domain.publishinghouse.Book;
import me.yurimatheus.casadocodigo.domain.publishinghouse.repositories.BookRepository;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(produces = "application/hal+json")
    public Resources<Book> list() {
        Iterable<Book> books = bookRepository.findAll();
        books.forEach(book -> book.add(book.getId()));

        Link link = linkTo(BookController.class).withSelfRel();

        return new Resources<>(books, link);
    }
}
