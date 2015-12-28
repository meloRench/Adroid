/*
package com.rc.news;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.rc.news.adapter.MyFragmentAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        initTabLayout();

      */
/*  ViewPager viewPager =(ViewPager)findViewById(R.id.viewpager);


        TabLayout tabLayout =(TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabTitle_news)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabTitle_pics)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabTitle_gmae)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabTitle_bbs)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tabTitle_hupuJrs)));
*//*

//        MyFragmentAdapter adapter =new MyFragmentAdapter(getSupportFragmentManager());
//        adapter.addFrag(new )
//        viewPager.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "这个按钮很好看^_^但是并没有什么卵用~", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
   */
/*
    private void setupViewPager(){
        final ViewPager viewPager =(ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout =(ViewPager)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
*//*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void initTabLayout(){
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tabs);
        ViewPager viewPager=(ViewPager)findViewById(R.id.viewpager);
*/
/*

        List<String> tablist =new ArrayList<>();
        tablist.add(getString(R.string.tabTitle_news));
        tablist.add(getString(R.string.tabTitle_pics));
        tablist.add(getString(R.string.tabTitle_gmae));
        tablist.add(getString(R.string.tabTitle_bbs));
        tablist.add(getString(R.string.tabTitle_hupuJrs));



        tabLayout.addTab(tabLayout.newTab().setText(tablist.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(tablist.get(nba_1)));
        tabLayout.addTab(tabLayout.newTab().setText(tablist.get(nba_2)));
        tabLayout.addTab(tabLayout.newTab().setText(tablist.get(nba_3)));
        tabLayout.addTab(tabLayout.newTab().setText(tablist.get(nba_4)));

        List<Fragment> fragmentList = new ArrayList<>();
        for (int i = 0; i < nba_5; i++) {
            Fragment f1 = new FragmentIndex();
            Bundle bundle = new Bundle();
            bundle.putString("content", "hahaha");
            f1.setArguments(bundle);
            fragmentList.add(f1);
        }

*//*



        MyFragmentAdapter adapter=new MyFragmentAdapter(getSupportFragmentManager());

        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        adapter.addFrag(new FragmentIndex(), getString(R.string.tabTitle_news));
        adapter.addFrag(new FragmentPic(), getString(R.string.tabTitle_pics));
        adapter.addFrag(new FragmentGame(), getString(R.string.tabTitle_gmae));
        adapter.addFrag(new FragmentBBS(), getString(R.string.tabTitle_bbs));
        adapter.addFrag(new FragmentJrs(), getString(R.string.tabTitle_hupuJrs));

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);


    }


}
*/
