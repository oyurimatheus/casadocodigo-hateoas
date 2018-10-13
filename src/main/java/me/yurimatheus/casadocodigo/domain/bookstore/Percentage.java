package me.yurimatheus.casadocodigo.domain.bookstore;

import java.math.BigDecimal;

public class Percentage {

    public static final Percentage TEN = new Percentage("0.1");
    public static final Percentage QUARTER = new Percentage("0.25");
    public static final Percentage HALF = new Percentage("0.5");

    private final BigDecimal value;

    public Percentage(String value) {
        this.value = verifyValue(value);;
    }

    private BigDecimal verifyValue(String value) {
        var discount = new BigDecimal(value);
        if(discount.compareTo(BigDecimal.ONE) >= 1)
            discount = discount.divide(new BigDecimal(100.0));
        return discount;
    }

    public BigDecimal getValue() {
        return value;
    }

    public BigDecimal getDiscountValue() {
        return BigDecimal.ONE.subtract(value);
    }
}