package com.rc.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rc.news.adapter.MyListAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by root on 15-12-16.
 */
public class FragmentJrs extends Fragment {

    private MyListAdapter mAdapter;

    private String mItemData = "热门评论 段子手正在赶来 马刺乐队组合";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_jrs,container,false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_jrs_list);

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
