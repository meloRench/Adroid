package com.rc.news.adapter;

//import android.app.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by root on 15-12-15.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {

    private final List<Fragment> list_fragment = new ArrayList<>();
    private final List<String> mTitles = new ArrayList<>();
    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }
    public int getCount() {
        return list_fragment.size();
    }

    public void addFrag(Fragment fragment, String title) {
        list_fragment.add(fragment);
        mTitles.add(title);
    }

    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
