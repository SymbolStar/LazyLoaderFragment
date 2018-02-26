package com.symbolstar.lazyloaderfragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ViewPager fragmentViewPager;
    private List<Fragment> fragments;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentViewPager = findViewById(R.id.vp_fragment);
        fragments = new ArrayList<>();
        fragments.add(FirstFragment.newInstance(true));
        fragments.add(SecondFragment.newInstance(true));
        fragments.add(ThirdFragment.newInstance(true));
        fragments.add(ForthFragment.newInstance(true));

        fragmentViewPager.setAdapter(new FragmentPageAdapter(getSupportFragmentManager(), fragments));
        fragmentViewPager.setOffscreenPageLimit(4);

    }
}
