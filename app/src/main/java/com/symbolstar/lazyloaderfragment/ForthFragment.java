package com.symbolstar.lazyloaderfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fujindong on 24/02/2018.
 */

public class ForthFragment extends LazyFragment {
    private static final String TAG = "ForthFragment";
    private static final String IS_LAZY = "is_lazy_loading";

    public static ForthFragment newInstance(boolean isLazy) {

        Bundle args = new Bundle();
        args.putBoolean(IS_LAZY, isLazy);
        ForthFragment forthFragment = new ForthFragment();
        forthFragment.setArguments(args);
        return forthFragment;
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void onCreateViewLazy(@Nullable Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_forth);
    }
}
