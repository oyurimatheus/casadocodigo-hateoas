package me.yurimatheus.casadocodigo.domain.publishinghouse.repositories;


import me.yurimatheus.casadocodigo.domain.publishinghouse.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;

import static org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import static org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;

public interface AuthorRepository extends Repository<Author, Long> {
    Author save(Author entity);
    Author findById(Long id);
    long count();
    boolean existsById(Long id);
    Iterable<Author> findAll();
    //Iterable<Author> findAll(Sort sort);
    //Page<Author> findAll(Pageable pageable);
}
