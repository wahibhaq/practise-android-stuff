package com.practise.androidstuff.managers;

import com.practise.androidstuff.api.CurrencyConvertorApi;
import com.practise.androidstuff.models.ConvertedItem;
import com.practise.androidstuff.models.CurrencyInfoItem;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class ActiveCurrencyConvertorManager implements CurrencyConvertorManager {

    private final CurrencyConvertorApi currencyConvertorApi;

    @Inject
    public ActiveCurrencyConvertorManager(CurrencyConvertorApi currencyConvertorApi) {
        this.currencyConvertorApi = currencyConvertorApi;
    }

    @Override
    public Observable<ArrayList<CurrencyInfoItem>> loadCurrencies() {
        return currencyConvertorApi.getSupportedCurrencies();
    }

    @Override
    public Observable<ConvertedItem> performConversion(String srcCurrency, double amountToConvert, String targetCurrency) {
        return currencyConvertorApi.getConvertedValue(srcCurrency, amountToConvert, targetCurrency);
    }

//    @Override
//    public Observable<Long> performConversion(String srcCurrency, double amountToConvert,
//                                              String targetCurrency) {
//
//        getConvertedValue(srcCurrency, amountToConvert, targetCurrency)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<ConvertedItem>() {
//                    @Override
//                    public void call(ConvertedItem convertedItem) {
//                        Log.d("retro", String.valueOf(convertedItem.getTargetAmount()));
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        //TODO add proper fall back and error message
////                        Toast.makeText(, "Network API Error",
////                                Toast.LENGTH_LONG).show();
//                        Log.d("retro", "API Errr : " + throwable.getMessage());
//
//                    }
//                });
//        return null;
//    }



//    public Observable<boolean> setup1() {
//
//        final long initialDelay = 5; // 5 seconds
//        final long period = 10; // 10 seconds
//        return currencyListSubscrition = Observable.interval(initialDelay, period, TimeUnit.SECONDS,
//                Schedulers.computation())
//                .flatMap(new Func1<boolean, Observable<ArrayList<CurrencyInfoItem>>>() {
//                    @Override
//                    public Observable<ArrayList<CurrencyInfoItem>> call(boolean b) {
//                        return getSupportedCurrenciesList();
//                    }
//                })
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnError(new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable e) {
////                        getView().showErrorToast(e.getMessage());
//                    }
//                })
//                .retry()
//                .subscribe(currentDataSubscriber());
//    }

//    public ArrayList<CurrencyInfoItem> getOfferedCurrencyList() {
//        return currencyInfoItems;
//    }


}
