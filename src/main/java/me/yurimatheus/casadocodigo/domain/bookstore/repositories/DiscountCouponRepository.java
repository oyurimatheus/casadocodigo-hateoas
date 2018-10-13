package me.yurimatheus.casadocodigo.domain.bookstore.repositories;

import me.yurimatheus.casadocodigo.domain.bookstore.DiscountCoupon;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;

import java.util.UUID;

import static org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import static org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;

public interface DiscountCouponRepository extends Repository<DiscountCoupon, UUID> {
    DiscountCoupon save(DiscountCoupon entity);
    DiscountCoupon findById(UUID id);
    long count();
    boolean existsById(UUID id);
    Iterable<DiscountCoupon> findAll();
    //Iterable<DiscountCoupon> findAll(Sort sort);
    //Page<DiscountCoupon> findAll(Pageable pageable);

}
