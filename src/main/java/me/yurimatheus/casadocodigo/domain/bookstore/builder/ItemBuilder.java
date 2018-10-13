package me.yurimatheus.casadocodigo.domain.bookstore.builder;

import me.yurimatheus.casadocodigo.domain.bookstore.BookType;
import me.yurimatheus.casadocodigo.domain.bookstore.ShoppingCart;
import me.yurimatheus.casadocodigo.domain.bookstore.CartItem;
import me.yurimatheus.casadocodigo.domain.common.Name;
import me.yurimatheus.casadocodigo.domain.common.Title;
import me.yurimatheus.casadocodigo.domain.publishinghouse.Author;
import me.yurimatheus.casadocodigo.domain.publishinghouse.Book;

import java.time.LocalDate;

public class ItemBuilder {

    private static final Book DEFAULT_BOOK = new Book(new Title("Java", "From zero to hero"),
                                               LocalDate.now(),
                                               new Author(new Name("Yuri", "Matheus")));
    private static final BookType DEFAULT_TYPE = BookType.EBOOK;
    private static final Integer DEFAULT_QUANTITY = 1;


    private static Book book = DEFAULT_BOOK;
    private static BookType type = DEFAULT_TYPE;
    private static Integer quantity = DEFAULT_QUANTITY;
    private static ShoppingCart cart;



    private ItemBuilder() {}

    public static ItemBuilderCart aItem() {
       return new ItemBuilderCart();
    }

    public static class ItemBuilderCart {

        public ItemBuilderCartDone inCart(ShoppingCart cart) {
            ItemBuilder.cart = cart;
            return new ItemBuilderCartDone();
        }

        public class ItemBuilderCartDone {

            public ItemBuilderCartDone ofBook(Book book) {
                ItemBuilder.book = book;
                return this;
            }


            public ItemBuilderCartDone ofType(BookType type) {
                ItemBuilder.type = type;
                return this;
            }

            public ItemBuilderCartDone withQuantity(Integer quantity) {
                ItemBuilder.quantity = quantity;
                return this;
            }

            public CartItem build() {
                return new CartItem(book, type, quantity, cart);
            }
        }
    }
}
