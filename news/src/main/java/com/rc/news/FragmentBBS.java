package com.rc.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.rc.news.adapter.MyListAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by root on 15-12-16.
 */
public class FragmentBBS extends Fragment {


    private WebView webView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bbs,container,false);




        webView = (WebView) view.findViewById(R.id.webview);
        webView.loadUrl("http://1.payrc.sinaapp.com/1.html");


        return view;
    }

}
