package com.example.stuartbryce.shoppingbasket;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by stuartbryce on 2017-07-23.
 */

public class BasketHashMapper {

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

}
