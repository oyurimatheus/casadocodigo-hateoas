package me.yurimatheus.casadocodigo.domain.publishinghouse.repositories;


import me.yurimatheus.casadocodigo.domain.publishinghouse.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;

import static org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import static org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;

public interface BookRepository extends Repository<Book, Long> {
    Book save(Book entity);
    Book findById(Long id);
    long count();
    boolean existsById(Long id);
    Iterable<Book> findAll();
    //Iterable<Book> findAll(Sort sort);
    //Page<Book> findAll(Pageable pageable);
}
