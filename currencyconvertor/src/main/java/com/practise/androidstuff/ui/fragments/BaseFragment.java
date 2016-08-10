package com.practise.androidstuff.ui.fragments;

import android.os.Bundle;
import android.view.View;

import com.practise.androidstuff.CCApplication;
import com.trello.rxlifecycle.components.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Base class for all fragments to introduce common
 * functionality.
 */
public abstract class BaseFragment extends RxFragment {
    //TODO see if i want to do in a similar way like in our Base Fragment

    private Unbinder unbinder;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CCApplication.get(getActivity()).component().inject(this);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
