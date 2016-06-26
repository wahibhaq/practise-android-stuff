package com.practise.androidstuff.network;

import com.google.common.collect.ImmutableList;
import com.practise.androidstuff.models.ConvertedItem;
import com.practise.androidstuff.models.CurrencyInfoItem;

import java.util.ArrayList;

import rx.Observable;

public interface CurrencyConvertorApi {

    Observable<ArrayList<CurrencyInfoItem>> getSupportedCurrencies();

    Observable<ConvertedItem> getConvertedValue(String fromCurrency, int amount, String toCurrency);
}
