package me.yurimatheus.casadocodigo.domain.bookstore;

import org.javamoney.moneta.Money;

import java.math.BigDecimal;

public enum BookType {
    EBOOK(Money.of(new BigDecimal("39.9"), "BRL")),
    PAPERBACK(Money.of(new BigDecimal("69.9"), "BRL")),
    HARDCOVER(Money.of(new BigDecimal("99.9"), "BRL"));

    private final Money price;

    BookType(Money price) {
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }
}
