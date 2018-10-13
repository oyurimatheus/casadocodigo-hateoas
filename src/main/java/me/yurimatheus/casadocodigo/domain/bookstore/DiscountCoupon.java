package me.yurimatheus.casadocodigo.domain.bookstore;

import org.javamoney.moneta.Money;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class DiscountCoupon {

    @Id
    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime expireIn;

    @Transient
    private Discount discount;

    private Boolean active;


    public DiscountCoupon(LocalDateTime createdAt, LocalDateTime expireIn, Discount discount) {
        this.id = UUID.randomUUID();
        this.createdAt = createdAt;
        this.expireIn = expireIn;
        this.discount = discount;
        this.active = Boolean.TRUE;
    }

    /**
     * hibernate only
     */
    @Deprecated
    DiscountCoupon() {}

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpireIn() {
        return expireIn;
    }

    public Discount getDiscount() {
        return discount;
    }

    public Boolean isActive() {
        return active;
    }

    public Money apply(Money subTotal) {
        return discount.apply(subTotal);
    }

    public void deactivate() {
        this.active = Boolean.FALSE;
    }
}
