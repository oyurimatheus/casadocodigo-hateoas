package me.yurimatheus.casadocodigo.domain.bookstore.repositories;

import me.yurimatheus.casadocodigo.domain.bookstore.ShoppingCart;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;

import java.util.UUID;

import static org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import static org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;

public interface CartRepository extends Repository<ShoppingCart, UUID> {
    ShoppingCart save(ShoppingCart entity);
    ShoppingCart findById(UUID id);
    long count();
    boolean existsById(UUID id);
    Iterable<ShoppingCart> findAll();
    //Iterable<ShoppingCart> findAll(Sort sort);
    //Page<ShoppingCart> findAll(Pageable pageable);
}
