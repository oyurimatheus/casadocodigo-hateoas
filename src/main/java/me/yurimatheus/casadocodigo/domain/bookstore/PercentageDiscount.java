package me.yurimatheus.casadocodigo.domain.bookstore;

import org.javamoney.moneta.Money;

public class PercentageDiscount implements Discount {

    private Percentage discount;

    public PercentageDiscount(Percentage discount) {
        this.discount = discount;
    }

    @Override
    public Money apply(Money subtotal) {
        return subtotal.multiply(discount.getDiscountValue());
    }
}
