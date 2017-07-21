package com.example.stuartbryce.shoppingbasket;

import java.util.ArrayList;

/**
 * Created by stuartbryce on 2017-07-21.
 */

class ShoppingBasket {

    private ArrayList<Item> contents;
    private boolean hasLoyaltyCard;

    public ShoppingBasket(boolean hasLoyaltyCard) {
        this.contents = new ArrayList<Item>();
        this.hasLoyaltyCard = hasLoyaltyCard;
    }

    public ShoppingBasket(ArrayList<Item> contents) {
        this.contents = contents;
        this.hasLoyaltyCard = false;
    }

    public void add(Item item) {
        contents.add(item);
    }

    public int countItems() {
        return contents.size();
    }

    public void remove(Item item) {
        contents.remove(item);
    }

    public ArrayList<Item> getContents() {
        return contents;
    }

    public void setContents(ArrayList<Item> contents) {
        this.contents = contents;
    }

    public void clear() {
        this.contents.clear();
    }

    public boolean hasLoyaltyCard() {
        return hasLoyaltyCard;
    }
}
