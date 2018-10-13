package me.yurimatheus.casadocodigo.domain.bookstore;

import org.javamoney.moneta.Money;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static me.yurimatheus.casadocodigo.domain.bookstore.builder.ItemBuilder.*;
import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {


    @Test
    public void shouldAddTotalInCartWhenAddItems() {
        var cart = new ShoppingCart();

        var ebook = aItem().inCart(cart).ofType(BookType.EBOOK).build();
        var paperback = aItem().inCart(cart).ofType(BookType.PAPERBACK).build();

        cart.addItem(ebook);
        cart.addItem(paperback);

        assertEquals(Money.of(new BigDecimal("109.8"), "BRL"), cart.getSubTotal());
        assertEquals(Money.of(new BigDecimal("109.8"), "BRL"), cart.getTotal());
    }

    @Test
    public void shouldApplyDiscountWhenDiscountTypeIsMonetary() {
        var cart = new ShoppingCart();

        var ebook = aItem().inCart(cart).ofType(BookType.EBOOK).build();

        cart.addItem(ebook);

        var discount = new DiscountCoupon(LocalDateTime.now(), LocalDateTime.now().plusDays(1), new MonetaryDiscount(Money.of(1, "BRL")));
        cart.applyDiscount(discount);

        assertEquals(Money.of(new BigDecimal("39.9"), "BRL"), cart.getSubTotal());
        assertEquals(Money.of(new BigDecimal("38.9"), "BRL"), cart.getTotal());
    }

    @Test
    public void shouldApplyDiscountWhenDiscountTypeIsPercentage() {
        var cart = new ShoppingCart();
        var ebook = aItem().inCart(cart).ofType(BookType.EBOOK).build();

        cart.addItem(ebook);
        var discount = new DiscountCoupon(LocalDateTime.now(), LocalDateTime.now().plusDays(1), new PercentageDiscount(Percentage.TEN));
        cart.applyDiscount(discount);

        assertEquals(Money.of(new BigDecimal("39.9"), "BRL"), cart.getSubTotal());
        assertEquals(Money.of(new BigDecimal("35.91"), "BRL"), cart.getTotal());
    }

    @Test
    public void shouldApplyDiscountWhenDiscountTypeIsPercentageWith20PerCentDiscount() {
        var cart = new ShoppingCart();
        var ebook = aItem().inCart(cart).ofType(BookType.EBOOK).build();

        cart.addItem(ebook);
        var discount = new DiscountCoupon(LocalDateTime.now(), LocalDateTime.now().plusDays(1), new PercentageDiscount(new Percentage("20")));
        cart.applyDiscount(discount);

        assertEquals(Money.of(new BigDecimal("39.9"), "BRL"), cart.getSubTotal());
        assertEquals(Money.of(new BigDecimal("31.92"), "BRL"), cart.getTotal());
    }

    @Test
    public void shouldApplyDiscountWhenDiscountTypeIsPercentageWith75PerCentDiscount() {
        var cart = new ShoppingCart();
        var ebook = aItem().inCart(cart).ofType(BookType.EBOOK).build();

        cart.addItem(ebook);
        var discount = new DiscountCoupon(LocalDateTime.now(), LocalDateTime.now().plusDays(1), new PercentageDiscount(new Percentage("0.75")));
        cart.applyDiscount(discount);

        assertEquals(Money.of(new BigDecimal("39.9"), "BRL"), cart.getSubTotal());
        assertEquals(Money.of(new BigDecimal("9.975"), "BRL"), cart.getTotal());
    }
}