package com.symbolstar.lazyloaderfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by fujindong on 24/02/2018.
 */

public class FragmentPageAdapter extends FragmentPagerAdapter {

    private static final String TAG = "FragmentPageAdapter";
    private List<Fragment> fragments;

    public FragmentPageAdapter(FragmentManager fragmentManager, List<Fragment> fragments) {
        super(fragmentManager);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
