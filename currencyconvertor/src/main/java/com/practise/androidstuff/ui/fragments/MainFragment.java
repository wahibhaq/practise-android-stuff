package com.practise.androidstuff.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.practise.androidstuff.CCApplication;
import com.practise.androidstuff.R;
import com.practise.androidstuff.managers.ActiveCurrencyConvertorManager;
import com.practise.androidstuff.models.CurrencyInfoItem;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MainFragment extends BaseFragment {

    @Inject
    protected ActiveCurrencyConvertorManager manager;

    @BindView(R.id.testText)
    protected TextView testText;

    private Subscription loadCurrencySubscription;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CCApplication.get(getActivity()).component().inject(this);
//        manager.performConversion("USD", 100.0, "EUR");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onDestroyView() {
        if(loadCurrencySubscription != null && !loadCurrencySubscription.isUnsubscribed()) {
            loadCurrencySubscription.unsubscribe();
        }
        super.onDestroyView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //TODO load progress bar

        loadCurrencySubscription = manager.loadCurrencies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        //TODO hide progressbar & show error message
                    }
                })
                .subscribe(currencyDataSubscriber());

    }

    /**
     * Prepares subscriber for the currency list data
     *
     * @return Subscriber
     */
    private Subscriber<ArrayList<CurrencyInfoItem>> currencyDataSubscriber() {
        return new Subscriber<ArrayList<CurrencyInfoItem>>() {

            @Override
            public void onCompleted() {
                // do nothing
            }

            @Override
            public void onError(Throwable e) {
                // do nothing, error handled in subscribing place
            }

            @Override
            public void onNext(ArrayList<CurrencyInfoItem> currencyInfoItems) {
                //TODO hide progress bar
                //TODO show currency list or whatever UI
                testText.setText(currencyInfoItems.get(0).getDescription().toString());

//                getView().setCurrentData(currentData);
            }
        };
    }
}
