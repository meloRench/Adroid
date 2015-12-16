package com.rc.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Created by root on 15-12-15.
 */
public class FragmentIndex extends Fragment {

/*
    Day 1 注释

    ViewPager viewPager =(ViewPager)findViewById(R.id.viewpager);


    TabLayout tabLayout =(TabLayout)findViewById(R.id.tabs);
    tabLayout.setupWithViewPager(viewPager);

    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabTitle_news)));
    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabTitle_pics)));
    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabTitle_gmae)));
    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabTitle_bbs)));
    tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabTitle_hupuJrs)));

    */
//        MyFragmentAdapter adapter =new MyFragmentAdapter(getSupportFragmentManager());
//        adapter.addFrag(new )
//        viewPager.setAdapter(adapter);

   /* private TabLayout tabLayout ;
    private ViewPager viewPager;
    private MyFragmentAdapter adapter;
*/
   /* Day2 原方法（可用）
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
*/
    private MyListAdapter mAdapter;

    private String mItemData = " hello hello hello hello hello hello hello hello hello hello hello hello hello hello hello ";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.myfragment,container,false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);


        String[] listItems = mItemData.split(" ");

        List<String> list = new ArrayList<>();
        Collections.addAll(list, listItems);

        mAdapter = new MyListAdapter(list);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }




}
