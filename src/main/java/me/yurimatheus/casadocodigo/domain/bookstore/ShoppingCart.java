package me.yurimatheus.casadocodigo.domain.bookstore;

import org.javamoney.moneta.Money;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Table(name = "carts")
@Entity
public class ShoppingCart {


    @Id
    private UUID id;
    private Money subTotal;
    private Money total;
    @OneToMany(mappedBy = "cart")
    private Set<CartItem> items;

    public ShoppingCart() {
        this.id = UUID.randomUUID();
        this.subTotal = Money.of(BigDecimal.ZERO, "BRL");
        this.total = Money.of(BigDecimal.ZERO, "BRL");
        this.items = new LinkedHashSet<>();
    }

    public UUID getId() {
        return id;
    }

    public Money getSubTotal() {
        return subTotal;
    }

    public Money getTotal() {
        return total;
    }

    public void addItem(CartItem cartItem) {
        items.add(cartItem);
        this.subTotal = subTotal.add(cartItem.getPrice());
        this.total = subTotal;
    }

    public Set<CartItem> getItems() {
        return new HashSet<>(items);
    }

    public void applyDiscount(DiscountCoupon coupon) {
        this.total = coupon.apply(subTotal);
    }
}
