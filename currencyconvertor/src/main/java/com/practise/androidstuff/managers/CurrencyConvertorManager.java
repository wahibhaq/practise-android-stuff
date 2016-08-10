package com.practise.androidstuff.managers;

import com.practise.androidstuff.models.ConvertedItem;
import com.practise.androidstuff.models.CurrencyInfoItem;

import java.util.ArrayList;

import rx.Observable;

public interface CurrencyConvertorManager {
    Observable<ArrayList<CurrencyInfoItem>> loadCurrencies();
    Observable<ConvertedItem> performConversion(String srcCurrency, double amountToConvert,
                                                String targetCurrency);
}
