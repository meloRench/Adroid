package com.rc.viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * Created by root on 15-12-11.
 */
public class myPagerAdapt extends PagerAdapter {

    private List<View>viewList;
    private List<String>titleList;

    public myPagerAdapt(List<View>viewList,List<String>titleList){
        this.viewList=viewList;
        this.titleList=titleList;
    }

    @Override
    public int getCount() {
        return viewList.size();

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        return super.instantiateItem(container, position);
          container.addView(viewList.get(position));
          return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(viewList.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
