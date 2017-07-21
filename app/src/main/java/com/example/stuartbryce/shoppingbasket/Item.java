package com.example.stuartbryce.shoppingbasket;

/**
 * Created by stuartbryce on 2017-07-21.
 */

class Item {
    private int price;
    private String name;
    private boolean offer;


    public Item(int price, String name) {
        this.price = price;
        this.name = name;
        this.offer = false;
    }

    public Item(int price, String name, boolean offer) {
        this.price = price;
        this.name = name;
        this.offer = offer;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean buyOneOffer() {
        return offer;
    }
}
