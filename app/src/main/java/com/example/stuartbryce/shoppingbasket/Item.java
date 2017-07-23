package com.example.stuartbryce.shoppingbasket;

/**
 * Created by stuartbryce on 2017-07-21.
 */

class Item {
    private float price;
    private String name;
    private boolean offer;


    public Item(float price, String name) {
        this.price = price;
        this.name = name;
        this.offer = false;
    }

    public Item(float price, String name, boolean offer) {
        this.price = price;
        this.name = name;
        this.offer = offer;
    }

    public int getPrice() {
        return CurrencyConverter.convertToInt(price);
    }

    public float getFloatPrice() {
        return this.price;
    }

    public String getName() {
        return name;
    }

    public boolean buyOneOffer() {
        return offer;
    }
}
