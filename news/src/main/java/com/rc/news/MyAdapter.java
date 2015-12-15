package com.rc.news;

//import android.app.Fragment;
import android.support.v4.app.Fragment;
//import android.app.FragmentManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by root on 15-12-15.
 */
public class MyAdapter extends FragmentPagerAdapter {

    List<Fragment> list_fragment ;
    private List<String> mTitles;


    public MyAdapter(FragmentManager fm,List<Fragment> fragments,List<String> titles) {
        super(fm);
        this.list_fragment = fragments;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }


    public int getCount() {
        return list_fragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

//        return mTitles.get(position % mTitles.size());
        return mTitles.get(position);
    }
}
