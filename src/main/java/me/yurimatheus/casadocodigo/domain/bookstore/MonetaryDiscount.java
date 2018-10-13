package me.yurimatheus.casadocodigo.domain.bookstore;

import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;

public class MonetaryDiscount implements Discount {

    private MonetaryAmount discount;

    public MonetaryDiscount(MonetaryAmount discount) {
        this.discount = discount;
    }

    @Override
    public Money apply(Money subtotal) {
        return subtotal.subtract(discount);
    }
}
