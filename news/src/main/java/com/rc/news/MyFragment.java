package com.rc.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


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
//        MyAdapter adapter =new MyAdapter(getSupportFragmentManager());
//        adapter.addFrag(new )
//        viewPager.setAdapter(adapter);

   /* private TabLayout tabLayout ;
    private ViewPager viewPager;
    private MyAdapter adapter;
*/
    private String content;
    private View view;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


    }

    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle saveInstanceState){
         view=inflater.inflate(R.layout.myfragment,container,false);

        return view;


    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        content = getArguments().getString("content");
        TextView tvContent = (TextView)view.findViewById(R.id.tab_content);
        tvContent.setText(content + "");
    }





}
