package com.practise.androidstuff.network;

import com.practise.androidstuff.models.ConvertedItem;
import com.practise.androidstuff.models.CurrencyInfoItem;

import java.util.List;

import rx.Observable;

public interface CurrencyConvertorApi {

    Observable<List<CurrencyInfoItem>> getSupportedCurrencies();

    Observable<ConvertedItem> getConvertedValue(String fromCurrency, int amount, String toCurrency);
}
