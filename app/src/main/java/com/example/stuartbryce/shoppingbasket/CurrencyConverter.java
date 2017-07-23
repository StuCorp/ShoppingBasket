package com.example.stuartbryce.shoppingbasket;

/**
 * Created by stuartbryce on 2017-07-22.
 */

class CurrencyConverter {


    public static float convertToFloat(int hundredsofpennnies) {
        return (float) hundredsofpennnies/100;
    }

    public static int convertToInt(float decimalPrice){
        return (int) decimalPrice *100;
    }
}


