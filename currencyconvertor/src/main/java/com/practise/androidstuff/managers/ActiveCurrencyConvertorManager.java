package com.practise.androidstuff.managers;

import android.util.Log;

import com.practise.androidstuff.api.RetrofitCurrencyConvertorApi;
import com.practise.androidstuff.models.ConvertedItem;
import com.practise.androidstuff.models.CurrencyInfoItem;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

@Singleton
public class ActiveCurrencyConvertorManager implements CurrencyConvertorManager {

    private final RetrofitCurrencyConvertorApi currencyConvertorApi;

    private ArrayList<CurrencyInfoItem> currencyInfoItems;

    private boolean status;

    @Inject
    public ActiveCurrencyConvertorManager(RetrofitCurrencyConvertorApi currencyConvertorApi) {
        this.currencyConvertorApi = currencyConvertorApi;
    }

//    public void showWhenReady(final AppCompatActivity appCompatActivity) {
//
//        getSupportedCurrenciesList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<ArrayList<CurrencyInfoItem>>() {
//                    @Override
//                    public void call(ArrayList<CurrencyInfoItem> items) {
//                        if (!currencyInfoItems.isEmpty()) {
//                            MainFragment fragment = MainFragment.newInstance(currencyInfoItems);
//                            appCompatActivity.getSupportFragmentManager().beginTransaction()
//                                    .add(R.id.content_frame, fragment)
//                                    .commit();
//                        }
//
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        //TODO add proper fall back and error message
//                        Toast.makeText(appCompatActivity, "Network API Error",
//                                Toast.LENGTH_LONG).show();
//                    }
//                });
//
//
//    }

    private Observable<ArrayList<CurrencyInfoItem>> getSupportedCurrenciesList() {
        return currencyConvertorApi.getSupportedCurrencies();
    }

    @Override
    public void performConversion(String srcCurrency, double amountToConvert,
                                            String targetCurrency) {

        getConvertedValue(srcCurrency, amountToConvert, targetCurrency)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ConvertedItem>() {
                    @Override
                    public void call(ConvertedItem convertedItem) {
                        Log.d("retro", String.valueOf(convertedItem.getTargetAmount()));
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        //TODO add proper fall back and error message
//                        Toast.makeText(, "Network API Error",
//                                Toast.LENGTH_LONG).show();
                        Log.d("retro", "API Errr : " + throwable.getMessage());

                    }
                });
    }

    private Observable<ConvertedItem> getConvertedValue(String srcCurrency, double amountToConvert,
                                                       String targetCurrency) {
        return currencyConvertorApi.getConvertedValue(srcCurrency, amountToConvert, targetCurrency);
    }

    @Override
    public boolean setup() {
        getSupportedCurrenciesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ArrayList<CurrencyInfoItem>>() {
                    @Override
                    public void call(ArrayList<CurrencyInfoItem> items) {
                        if (!currencyInfoItems.isEmpty()) {
                            currencyInfoItems = items;
                            status = true;
                        } else {
                            status = false;
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        //TODO add proper fall back and error message
//                        Toast.makeText(appCompatActivity, "Network API Error",
//                                Toast.LENGTH_LONG).show();
                        status = false;
                    }
                });

        return status;
    }

    public ArrayList<CurrencyInfoItem> getOfferedCurrencyList() {
        return currencyInfoItems;
    }


}
