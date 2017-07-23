package com.example.stuartbryce.shoppingbasket;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by stuartbryce on 2017-07-21.
 */

public class ShoppingBasketTest {

    ShoppingBasket basket;
    ShoppingBasket basketNoCard;
    Item item;
    Item item2;


    @Before
    public void setup() {
        basket = new ShoppingBasket(true);
        basketNoCard = new ShoppingBasket(false);
        item = new Item((float) 10.00, "sausage", true);
        item2 = new Item((float) 5.00, "bun", true);
    }

    @Test
    public void basketHasItem() throws Exception{
        basket.add(item);
        assertEquals(1, basket.countItems());
    }

    @Test
    public void removeItemTest() throws Exception {
        basket.add(item);
        basket.remove(item);
        assertEquals(0, basket.countItems());
    }

    @Test
    public void testRemoveAllItems() throws Exception {
        basket.add(item);
        basket.add(item);
        basket.clear();
        assertEquals(0, basket.countItems());
    }

    @Test
    public void testItemHasPrice() throws Exception {
        assertEquals(10.00, item.getFloatPrice(), 0.02);
    }

    @Test
    public void testItemHasName() throws Exception {
        assertEquals("sausage", item.getName());
    }

    @Test
    public void testCashRegisterTotals() throws Exception {
        basketNoCard.add(item);
        basketNoCard.add(item);
        assertEquals(10, CashRegister.total(basketNoCard), 0.02);
    }

    @Test
    public void testItemHasOffer() throws Exception {
        assertEquals(true, item.buyOneOffer());
    }

    @Test
    public void testGetHashMapOfItems() throws Exception {
        basket.add(item);
        basket.add(item);
        HashMap<Item, Integer> hashMapOfItems = BasketHashMapper.getHashMapOfItems(basket);
        assertEquals((Integer) 2, hashMapOfItems.get(item));
    }

    @Test
    public void testSubTotalMethodAppliesOneFreeDiscount() throws Exception {
        basketNoCard.add(item);
        basketNoCard.add(item);
        assertEquals(10, CashRegister.total(basketNoCard), 0.02);
    }

    @Test
    public void testSubTotalHandlesMultipleDiscountItems() throws Exception {
        basketNoCard.add(item);
        basketNoCard.add(item);
        basketNoCard.add(item);
        basketNoCard.add(item2);
        basketNoCard.add(item2);
        int subtotal = CashRegister.subtotal(basketNoCard);
        float floatal = CurrencyConverter.convertToFloat(subtotal);
        assertEquals(25, floatal, 0.02);
    }

    @Test
    public void testTwoPercentDiscount() throws Exception {
        basket.add(item);
        basket.add(item);
        basket.add(item);
        basket.add(item2);
        basket.add(item2);
        int subtotal = CashRegister.subtotal(basket);
        int total = CashRegister.applyDiscount(subtotal, 2);
        float floatal = CurrencyConverter.convertToFloat(total);
        assertEquals(24.50, floatal, 0.02);
    }

    @Test
    public void testFivePercentDiscount() throws Exception {
        basket.add(item);
        basket.add(item);
        basket.add(item);
        basket.add(item2);
        basket.add(item2);
        int subtotal = CashRegister.subtotal(basket);
        int total = CashRegister.applyDiscount(subtotal, 5);
        float floatal = CurrencyConverter.convertToFloat(total);
        assertEquals(23.75, floatal, 0.02);
    }

    @Test
    public void testBasketHasLoyaltyCard() throws Exception {
        assertEquals(true, basket.hasLoyaltyCard());
    }

    @Test
    public void testTotalGivesAllDiscountsOwed() throws Exception {
        basket.add(item);
        basket.add(item);
        basket.add(item);
        basket.add(item2);
        basket.add(item2);
        assertEquals(22.05, CashRegister.total(basket), 0.02);
    }
}
