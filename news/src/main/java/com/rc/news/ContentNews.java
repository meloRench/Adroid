package com.rc.news;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by root on 15-12-20.
 */
public class ContentNews extends AppCompatActivity {

    private SimpleDraweeView content_photo;
    private TextView content_title;
    private TextView content_info;
//    private WebView content_webview;
    private TextView content_content;


    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.content_news);
        content_info=(TextView)findViewById(R.id.content_title);
        content_content=(TextView)findViewById(R.id.content_content);
        content_photo = (SimpleDraweeView)findViewById(R.id.news_content_photo);
        Intent intent =getIntent();

        String title=intent.getStringExtra("title");
        String content=intent.getStringExtra("content");
        String url=intent.getStringExtra("url");
        content_info.setText(title);
        content_content.setText(content);
        Uri uri = Uri.parse(url);
        content_photo.setImageURI(uri);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.content_toolbar);
        setSupportActionBar(mToolbar);
        CollapsingToolbarLayout mCollapsingToolbarLayout =
                (CollapsingToolbarLayout) findViewById(R.id.content_collapsing);
        mCollapsingToolbarLayout.setTitle(title);
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

}