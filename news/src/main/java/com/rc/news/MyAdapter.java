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

    public MyAdapter(FragmentManager fm) {
        super(fm);
//        this.list_fragment = list_fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return list_fragment.get(position);
    }


    public int getCount() {
        return list_fragment.size();
    }
/*
    //此方法用来显示tab上的名字
    @Override
    public CharSequence getPageTitle(int position) {

        return list_Title.get(position % list_Title.size());
    }*/
}
