package com.practise.androidstuff.managers;

import com.practise.androidstuff.models.CurrencyInfoItem;

import java.util.ArrayList;

public interface CurrencyConvertorManager {
    boolean setup();
    void performConversion(String srcCurrency, double amountToConvert,
                           String targetCurrency);
}
