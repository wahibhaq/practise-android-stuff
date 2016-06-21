package com.practise.androidstuff.network;

import android.support.annotation.NonNull;

import com.google.common.collect.ImmutableList;
import com.practise.androidstuff.models.ConvertedItem;
import com.practise.androidstuff.models.CurrencyInfoItem;
import com.practise.androidstuff.models.CurrencyInfoResponse;

import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.google.common.base.Preconditions.checkNotNull;

public class RetrofitCurrencyConvertorApi implements CurrencyConvertorApi {

    //TODO Understand and add own ErrorConvertor

    private final RetrofitService retrofitService;

    public RetrofitCurrencyConvertorApi(@NonNull Retrofit retrofit) {
        retrofitService = retrofit.create(RetrofitService.class);
    }

    public interface RetrofitService {

        @GET("/availablecurrencies")
        Observable<CurrencyInfoResponse> getSupportedCurrencies();

        @GET("/?from={from}&from_amount={from_amount}&to={to}")
        Observable<ConvertedItem> getConvertedValue(@Path("from") String fromCurrency,
                                                    @Path("from_amount") int amount,
                                                    @Path("to") String toCurrency);
    }

    @Override
    public Observable<ImmutableList<CurrencyInfoItem>> getSupportedCurrencies() {

        //TODO add onErrorResumeNext
        return retrofitService.getSupportedCurrencies()
                .map(CurrencyInfoResponse.UNWRAP_FUNCTION)
                .unsubscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io());
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
