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
    Item item;
    Item item2;

    @Before
    public void setup(){
        basket = new ShoppingBasket(true);
        item = new Item(10, "sausage", true);
        item2 = new Item(5, "bun", true);
    }

    @Test
    public void basketHasItem(){
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
        assertEquals(10, item.getPrice());
    }

    @Test
    public void testItemHasName() throws Exception {
        assertEquals("sausage", item.getName());
    }

    @Test
    public void testCashRegisterTotals() throws Exception {
        basket.add(item);
        basket.add(item);
        assertEquals(10, CashRegister.subtotal(basket));
    }

    @Test
    public void testItemHasOffer() throws Exception {
        assertEquals(true, item.buyOneOffer());
    }

    @Test
    public void testGetHashMapOfItems() throws Exception {
        basket.add(item);
        basket.add(item);
        HashMap<Item, Integer> hashMapOfItems = CashRegister.getHashMapOfItems(basket);
        assertEquals((Integer) 2, hashMapOfItems.get(item));
    }

    @Test
    public void testSubTotalMethodAppliesOneFreeDiscount() throws Exception {
        basket.add(item);
        basket.add(item);
        assertEquals(10, CashRegister.subtotal(basket));
    }

    @Test
    public void testSubTotalHandlesMultipleDiscountItems() throws Exception {
        basket.add(item);
        basket.add(item);
        basket.add(item);
        basket.add(item2);
        basket.add(item2);
        assertEquals(25, CashRegister.subtotal(basket));
    }

    @Test
    public void testTwoPercentDiscount() throws Exception {
        basket.add(item);
        basket.add(item);
        basket.add(item);
        basket.add(item2);
        basket.add(item2);
        assertEquals(24.50, CashRegister.applyDiscount(basket, 2), 0.02);
    }

    @Test
    public void testFivePercentDiscount() throws Exception {
        basket.add(item);
        basket.add(item);
        basket.add(item);
        basket.add(item2);
        basket.add(item2);
        assertEquals(23.75, CashRegister.applyDiscount(basket, 5), 0.02);
    }

    @Test
    public void testBasketHasLoyaltyCard() throws Exception {
        assertEquals(true, basket.hasLoyaltyCard());

    }

    @Test
    public void testTotalGivesAllDiscountsOwed() throws Exception {


    }
}
