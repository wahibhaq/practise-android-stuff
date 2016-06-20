package com.practise.androidstuff.network;

import com.practise.androidstuff.models.ConvertedItem;
import com.practise.androidstuff.models.CurrencyInfoItem;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public class RetrofitCurrencyConvertorApi implements CurrencyConvertorApi {

//    private final RetrofitService retrofitService;

    public interface RetrofitService {

        @GET("/availablecurrencies")
        Observable<List<CurrencyInfoItem>> getSupportedCurrencies();

        @GET("/?from={from}&from_amount={from_amount}&to={to}")
        Observable<ConvertedItem> getConvertedValue(@Path("from") String fromCurrency,
                                                    @Path("from_amount") int amount,
                                                    @Path("to") String toCurrency);
    }

    @Override
    public Observable<List<CurrencyInfoItem>> getSupportedCurrencies() {
        return null;
    }

    @Override
    public Observable<ConvertedItem> getConvertedValue(String fromCurrency, int amount, String toCurrency) {
        return null;
    }
}
