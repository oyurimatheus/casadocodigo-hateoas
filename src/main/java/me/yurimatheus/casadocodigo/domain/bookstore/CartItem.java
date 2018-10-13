package me.yurimatheus.casadocodigo.domain.bookstore;

import me.yurimatheus.casadocodigo.domain.publishinghouse.Book;
import org.javamoney.moneta.Money;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Table(name = "items")
@Entity
public class CartItem {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne
    @MapsId
    private Book book;

    private Money price;

    @Enumerated(value = STRING)
    private BookType type;
    private Integer quantity;

    @ManyToOne
    private ShoppingCart cart;

    public CartItem(Book book, BookType type, Integer quantity, ShoppingCart cart) {
        this.book = book;
        this.type = type;
        this.quantity = quantity;
        this.cart = cart;
        this.price = type.getPrice().multiply(quantity) ;
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Money getPrice() {
        return price;
    }

    public BookType getType() {
        return type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public ShoppingCart getCart() {
        return cart;
    }
}
