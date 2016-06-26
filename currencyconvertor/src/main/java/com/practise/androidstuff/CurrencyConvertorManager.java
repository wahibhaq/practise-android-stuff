package com.practise.androidstuff;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.common.collect.ImmutableList;
import com.practise.androidstuff.models.CurrencyInfoItem;
import com.practise.androidstuff.network.RetrofitCurrencyConvertorApi;
import com.practise.androidstuff.views.MainFragment;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class CurrencyConvertorManager {

    RetrofitCurrencyConvertorApi currencyConvertorApi;

    @Inject
    public CurrencyConvertorManager(RetrofitCurrencyConvertorApi currencyConvertorApi) {
        this.currencyConvertorApi = currencyConvertorApi;
    }

    public void showWhenReady(final AppCompatActivity appCompatActivity) {

        getSupportedCurrenciesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ArrayList<CurrencyInfoItem>>() {
                    @Override
                    public void call(ArrayList<CurrencyInfoItem> currencyInfoItems) {
                        if (!currencyInfoItems.isEmpty()) {
                            MainFragment fragment = MainFragment.newInstance(currencyInfoItems);
                            appCompatActivity.getSupportFragmentManager().beginTransaction()
                                    .add(R.id.content_frame, fragment)
                                    .commit();
                        }

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        //TODO add proper fall back and error message
                        Toast.makeText(appCompatActivity, "Network API Error",
                                Toast.LENGTH_LONG).show();
                    }
                });


    }

    private Observable<ArrayList<CurrencyInfoItem>> getSupportedCurrenciesList() {
        return currencyConvertorApi.getSupportedCurrencies();
    }

}
