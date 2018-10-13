package me.yurimatheus.casadocodigo.domain.bookstore;

import org.javamoney.moneta.Money;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Table(name = "carts")
@Entity
public class ShoppingCart extends ResourceSupport {


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

    @Override
    public Link getId() {
        return linkTo(CartItem.class).slash("shoppingcarts").slash(id).withSelfRel();
    }

    public UUID getShoppingCartId() {
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
