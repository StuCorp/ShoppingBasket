package com.example.stuartbryce.shoppingbasket;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by stuartbryce on 2017-07-21.
 */

public class CashRegister {

    public static int subtotal(ShoppingBasket basket) {
        HashMap<Item, Integer> hashedItems = getHashMapOfItems(basket);
        Set<Item> itemsList = hashedItems.keySet();

        int subtotal = 0;
        for (Item item : itemsList){
            int numOfItem = hashedItems.get(item);
            int discount = 0;
            subtotal += numOfItem * item.getPrice();
            if (item.buyOneOffer() && numOfItem>1){
                discount = ((numOfItem - (numOfItem % 2))/2)* item.getPrice();
            }
            subtotal -= discount;
        }
       return  subtotal;
    }

//    public static int total(ShoppingBasket basket) {
//        int runningTotal = subtotal(basket);
//    }

    public static HashMap<Item, Integer> getHashMapOfItems(ShoppingBasket basket) {
        ArrayList<Item> contents = basket.getContents();
        HashMap<Item, Integer> itemDuplicates = new HashMap<>();
        for (Item item : contents) {
            if (itemDuplicates.containsKey(item)) {
                int num = itemDuplicates.get(item);
                itemDuplicates.put(item, (num + 1));
            } else {
                itemDuplicates.put(item, 1);
            }
        }
        return itemDuplicates;
    }

    public static float applyDiscount(ShoppingBasket basket, int percentageOff) {
        int subtotal = subtotal(basket) * 100;
        subtotal *= (100 - percentageOff);
        float newTotal = (float) subtotal/10000;
        return newTotal;
    }
}