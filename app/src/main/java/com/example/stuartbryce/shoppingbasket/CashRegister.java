package com.example.stuartbryce.shoppingbasket;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by stuartbryce on 2017-07-21.
 */

public class CashRegister {

    public static int subtotal(ShoppingBasket basket) {
        HashMap<Item, Integer> hashedItems = BasketHashMapper.getHashMapOfItems(basket);
        Set<Item> itemsList = hashedItems.keySet();
        int subtotal = 0;
        for (Item item : itemsList) {
            int numOfItem = hashedItems.get(item);
            int discount = 0;
            subtotal += numOfItem * item.getPrice();
            if (item.buyOneOffer() && numOfItem > 1) {
                discount = ((numOfItem - (numOfItem % 2)) / 2) * item.getPrice();
            }
            subtotal -= discount;
        }
        return subtotal;
    }

    public static int applyDiscount(int amount, float percentageOff) {
        amount *= (100 - percentageOff) / 100;
        return amount;
    }

    public static float total(ShoppingBasket basket) {
        int subtotal = subtotal(basket);
        if (subtotal > 2000) {
            subtotal = applyDiscount(subtotal, 10);
        }
        if (basket.hasLoyaltyCard()) {
            subtotal = applyDiscount(subtotal, 2);
        }
        float total = CurrencyConverter.convertToFloat(subtotal);
        return total;
    }
}