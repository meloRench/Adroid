package com.rc.news;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by root on 15-12-15.
 */
public class MyFragment extends Fragment {

/*
    ViewPager viewPager =(ViewPager)findViewById(R.id.viewpager);


    TabLayout tabLayout =(TabLayout)findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(viewPager);

    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabTitle_news)));
    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabTitle_pics)));
    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabTitle_gmae)));
    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabTitle_bbs)));
    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabTitle_hupuJrs)));

    */
//        myAdapter adapter =new myAdapter(getSupportFragmentManager());
//        adapter.addFrag(new )
//        viewPager.setAdapter(adapter);

    private TabLayout tabLayout ;
    private ViewPager viewPager;
    private myAdapter adapter;

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState){
        View v=inflater.inflate(R.layout.myfragment,container,false);
        return v;

    }


}
