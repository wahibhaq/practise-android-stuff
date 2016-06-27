package com.practise.androidstuff.models;

import com.google.common.collect.ImmutableList;

import rx.functions.Func1;

public class CurrencyInfoResponse {

    public static final Func1<CurrencyInfoResponse, ImmutableList<CurrencyInfoItem>> UNWRAP_FUNCTION
            = new Func1<CurrencyInfoResponse, ImmutableList<CurrencyInfoItem>>() {
        @Override
        public ImmutableList<CurrencyInfoItem> call(CurrencyInfoResponse currencyInfoResponse) {
            return currencyInfoResponse.getCurrencyInfoItems();
        }
    };

    private CurrencyInfoItem[] currencyInfoItems;

    public ImmutableList<CurrencyInfoItem> getCurrencyInfoItems() {
        if (currencyInfoItems == null) {
            return ImmutableList.of();
        }
        return ImmutableList.copyOf(currencyInfoItems);
    }
}
