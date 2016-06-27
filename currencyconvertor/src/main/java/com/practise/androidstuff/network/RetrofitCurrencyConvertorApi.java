package com.practise.androidstuff.network;

import android.support.annotation.NonNull;

import com.practise.androidstuff.models.ConvertedItem;
import com.practise.androidstuff.models.CurrencyInfoItem;

import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static com.google.common.base.Preconditions.checkNotNull;

public class RetrofitCurrencyConvertorApi implements CurrencyConvertorApi {

    //TODO Understand and add own ErrorConvertor

    private final RetrofitService retrofitService;

    @Inject
    public RetrofitCurrencyConvertorApi(@NonNull Retrofit retrofit) {
        retrofitService = retrofit.create(RetrofitService.class);
    }

    public interface RetrofitService {

        @GET("/availablecurrencies")
        Observable<CurrencyInfoItem[]> getSupportedCurrencies();

        @GET("/?from={from}&from_amount={from_amount}&to={to}")
        Observable<ConvertedItem> getConvertedValue(@Path("from") String fromCurrency,
                                                    @Path("from_amount") int amount,
                                                    @Path("to") String toCurrency);
    }

    @Override
    public Observable<ArrayList<CurrencyInfoItem>> getSupportedCurrencies() {

        //TODO add onErrorResumeNext
        return retrofitService.getSupportedCurrencies()
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .map(new Func1<CurrencyInfoItem[], ArrayList<CurrencyInfoItem>>() {
                    @Override
                    public ArrayList<CurrencyInfoItem> call(CurrencyInfoItem[] currencyInfoItems) {
                        if (currencyInfoItems == null) {
                            return new ArrayList<>();
                        }
                        return new ArrayList<>(Arrays.asList(currencyInfoItems));
                    }
                });

    }

    @Override
    public Observable<ConvertedItem> getConvertedValue(String fromCurrency, int amount, String toCurrency) {
        checkNotNull(fromCurrency);
        checkNotNull(amount);
        checkNotNull(toCurrency);

        //TODO add onErrorResumeNext
        return retrofitService.getConvertedValue(fromCurrency, amount, toCurrency)
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
