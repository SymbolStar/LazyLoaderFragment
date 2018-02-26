package com.symbolstar.lazyloaderfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by fujindong on 24/02/2018.
 */

public  class LazyFragment extends BaseFragment {
    private static final String TAG = "LazyFragment";
    public static final String IS_LAZY = "is_lazy_loading";
    private boolean isLazy;
    private boolean isInit = false;
    private boolean isStart = false;


    private Bundle savedInstanceState;

    private FrameLayout layout;

    private View contentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
            return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        Log.e(TAG, "protected void onCreateView");
        Bundle bundle = getArguments();
        if (bundle != null) {
            isLazy = bundle.getBoolean(IS_LAZY,true);
        }
        //初始化 view 为懒加载的页面 也可以在newInstance 的时候将layoutResID传过来
        //如果不初始化 会出现首页不显示的问题
        layout = new FrameLayout(getContext());
        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        View view = LayoutInflater.from(getContext()).inflate(R.layout.view_lazy, null);
        layout.addView(view);
        super.setContentView(layout);

        if (isLazy) {
            if (getUserVisibleHint() && !isInit) {
                this.savedInstanceState = savedInstanceState;
                onCreateViewLazy(savedInstanceState);
                isInit = true;
            }
        } else {
            onCreateViewLazy(savedInstanceState);
            isInit = true;
        }
    }

    protected  void onCreateViewLazy(@Nullable Bundle savedInstanceState){

    }




    //fragment 显示和隐藏的时候会回调此方法
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        Log.e(TAG, "setUserVisibleHint   " + (isVisibleToUser ? "true" : "false"));
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser && !isInit && getContentView() != null) {
            onCreateViewLazy(savedInstanceState);
            isInit = true;
            onResumeLazy();
        }

        if (isInit && getContentView() != null) {
            if (isVisibleToUser) {
                isStart = true;
                onFragmentStartLazy();
            } else {
                isStart = false;
                onFragmentStopLazy();
            }
        }
    }

    public void setContentView(int layoutResID) {
        if (isLazy && getContentView() != null && getContentView().getParent() != null) {
            Log.e(TAG, "setContentView if");
            layout.removeAllViews();
            View view = inflater.inflate(layoutResID, layout, false);
            layout.addView(view);
        } else {
            Log.e(TAG, "setContentView else");
            super.setContentView(layoutResID);
        }
    }

    public void setContentView(View view) {
        if (isLazy && getContentView() != null && getContentView().getParent() != null) {
            layout.removeAllViews();
            layout.addView(view);
        } else {
            super.setContentView(view);
        }
    }


    //当Fragment被滑到可见的位置时，调用
    protected void onFragmentStartLazy() {
        Log.d("TAG", "onFragmentStartLazy() called with: " + "");
    }

    //当Fragment被滑到不可见的位置，offScreen时，调用
    protected void onFragmentStopLazy() {
        Log.d("TAG", "onFragmentStopLazy() called with: " + "");
    }



    protected void onResumeLazy() {
        Log.d("TAG", "onResumeLazy() called with: " + "");
    }

}
