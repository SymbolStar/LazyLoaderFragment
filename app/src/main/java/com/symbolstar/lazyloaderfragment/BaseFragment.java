package com.symbolstar.lazyloaderfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;

/**
 * Created by fujindong on 24/02/2018.
 */

public class BaseFragment extends Fragment {

    private static final String TAG = "BaseFragment";
    protected LayoutInflater inflater;
    private ViewGroup container;
    private View contentView;
    private Context context;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView");
        this.inflater = inflater;
        this.container = container;
        onCreateView(savedInstanceState);
        if (contentView == null) {
            return super.onCreateView(inflater, container, savedInstanceState);
        } else {
            return contentView;
        }
    }

    protected void onCreateView(Bundle savedInstanceState) {
        Log.e(TAG, "protected void onCreateView");
    }

    public void setContentView(int layoutResID) {
        Log.e(TAG, "public void setContentView    "+String.valueOf(layoutResID));
        setContentView(inflater.inflate(layoutResID, container, false));
    }

    public void setContentView(View view) {
        contentView = view;
    }

    //最外层的fragment 调用
    public View findViewById(int id) {
        if (contentView != null) {
            return contentView.findViewById(id);
        } else {
            return null;
        }
    }


    public View getContentView() {
        return contentView;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    // http://stackoverflow.com/questions/15207305/getting-the-error-java-lang-illegalstateexception-activity-has-been-destroyed
    @Override
    public void onDetach() {
        Log.d("TAG", "onDetach() : ");
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
