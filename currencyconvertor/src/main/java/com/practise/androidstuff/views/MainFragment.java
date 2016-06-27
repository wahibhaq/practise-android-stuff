package com.practise.androidstuff.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.practise.androidstuff.CCApplication;
import com.practise.androidstuff.CurrencyConvertorManager;
import com.practise.androidstuff.R;
import com.practise.androidstuff.models.CurrencyInfoItem;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends BaseFragment {

    private static final String ARGS_CURRENCY_ITEMS = "currency_items";

    @Inject
    CurrencyConvertorManager manager;

    @BindView(R.id.testText)
    TextView testText;

    private ArrayList<CurrencyInfoItem> currencyInfoItems;


    public static MainFragment newInstance(
            @NonNull ArrayList<CurrencyInfoItem> currencyInfoItems) {

        MainFragment fragment = new MainFragment();
        Bundle arguments = new Bundle(1);
        arguments.putParcelableArrayList(ARGS_CURRENCY_ITEMS, currencyInfoItems);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CCApplication.get(getActivity()).component().inject(this);
        ButterKnife.bind(getActivity());

        Bundle arguments = getArguments();
        currencyInfoItems = arguments.getParcelableArrayList(ARGS_CURRENCY_ITEMS);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        testText.setText(currencyInfoItems.toString());
    }
}
