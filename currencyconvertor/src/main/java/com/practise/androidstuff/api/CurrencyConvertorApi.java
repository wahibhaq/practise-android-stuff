package com.practise.androidstuff.api;

import com.practise.androidstuff.models.ConvertedItem;
import com.practise.androidstuff.models.CurrencyInfoItem;

import java.util.ArrayList;

import rx.Observable;

public interface CurrencyConvertorApi {

    Observable<ArrayList<CurrencyInfoItem>> getSupportedCurrencies();

    Observable<ConvertedItem> getConvertedValue(String fromCurrency, double amount, String toCurrency);
}
