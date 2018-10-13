package me.yurimatheus.casadocodigo.domain.bookstore;

import org.javamoney.moneta.Money;

public interface Discount {

    Money apply(Money subtotal);
}
