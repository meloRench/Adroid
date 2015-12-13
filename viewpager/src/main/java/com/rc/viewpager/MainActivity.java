package com.rc.viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<View>viewList;
    private ViewPager pager;
//    private PagerTabStrip tap;
    private List<String>titleList;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewList = new ArrayList<>();
        View view1=View.inflate(this,R.layout.view1,null);
        View view2=View.inflate(this,R.layout.view2,null);
        View view3=View.inflate(this,R.layout.view3,null);
        View view4=View.inflate(this,R.layout.view4,null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);

        titleList=new ArrayList<>();
        titleList.add("page1");
        titleList.add("page2");
        titleList.add("page3");
        titleList.add("page4");

        pager=(ViewPager)findViewById(R.id.pager);

        myPagerAdapt adapter=new myPagerAdapt(viewList,titleList);
        pager.setAdapter(adapter);
    }
}
