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

    @Before
    public void setup(){
        basket = new ShoppingBasket();
        item = new Item(10, "sausage", true);
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
        assertEquals(20, CashRegister.subtotal(basket));
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


    }

    //    @Test
//    public void testBuyOneGetOneFreeDiscount() throws Exception {
//        basket.add(item);
//        basket.add(item);
//        assertEquals(20, CashRegister.total(basket));
//    }
}
