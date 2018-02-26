package com.symbolstar.lazyloaderfragment;

import android.content.Context;
import android.nfc.Tag;
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

public class FirstFragment extends LazyFragment {
    private static final String TAG = "FirstFragment";
    private static final String IS_LAZY = "is_lazy_loading";

    public static FirstFragment newInstance(boolean isLazy) {
        Log.e(TAG, "FirstFragment newInstance");
        Bundle args = new Bundle();
        args.putBoolean(IS_LAZY, isLazy);
        FirstFragment firstFragment = new FirstFragment();
        firstFragment.setArguments(args);
        return firstFragment;
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
        Log.e(TAG, "onCreateViewLazy");
//        setContentView(R.layout.fragment_first);
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
            setContentView(R.layout.fragment_first);
        }
    };
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.e(TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.e(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e(TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e(TAG, "onStop");
        super.onStop();
    }


    @Override
    public void onAttach(Context context) {
        Log.e(TAG, "onAttach");
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        Log.e(TAG, "onDetach");
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.e(TAG, "onDestroyView");
        super.onDestroyView();
    }
}
