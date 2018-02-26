package com.symbolstar.lazyloaderfragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fujindong on 24/02/2018.
 */

public class SecondFragment extends LazyFragment {
    private static final String TAG = "SecondFragment";
    private static final String IS_LAZY = "is_lazy_loading";

    public static SecondFragment newInstance(boolean isLazy) {

        Bundle args = new Bundle();
        args.putBoolean(IS_LAZY, isLazy);
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(args);
        return secondFragment;
    }

    @Override
    protected void onCreateViewLazy(@Nullable Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        Log.e(TAG, "onCreateViewLzay");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                handler.sendEmptyMessage(1);

            }
        }).start();


    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.e(TAG, String.valueOf(msg.what));
            setContentView(R.layout.fragment_second);
        }
    };

    //
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        Log.e(TAG, "onCreateView");
//        View view = inflater.inflate(R.layout.fragment_second, container, false);
//        return view;
//    }
}
