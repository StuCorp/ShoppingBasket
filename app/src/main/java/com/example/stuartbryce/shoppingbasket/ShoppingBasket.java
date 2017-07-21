package com.example.stuartbryce.shoppingbasket;

import java.util.ArrayList;

/**
 * Created by stuartbryce on 2017-07-21.
 */

class ShoppingBasket {

    private ArrayList<Item> contents;

    public ShoppingBasket() {
        contents = new ArrayList<Item>();
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
}
