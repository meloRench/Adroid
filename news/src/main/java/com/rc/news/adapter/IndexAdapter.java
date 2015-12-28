package com.rc.news.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.facebook.drawee.view.SimpleDraweeView;
import com.rc.news.ContentNews;
import com.rc.news.FragmentIndex;
import com.rc.news.R;

import java.util.List;

/**
 * Created by root on 15-12-16.
 */
public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.IndexViewHolder> {

    private List<FragmentIndex.IndexSerializable> news;
    private Context context;


    public IndexAdapter(List<FragmentIndex.IndexSerializable> news, Context context){
        this.context = context;
        this.news = news;
    }

    static class IndexViewHolder extends RecyclerView.ViewHolder {

        CardView index_list;
        SimpleDraweeView photo;
        TextView title;
        public  IndexViewHolder(final View itemView) {
            super(itemView);
            index_list = (CardView) itemView.findViewById(R.id.index_list);
            photo = (SimpleDraweeView)itemView.findViewById(R.id.photo);
            title = (TextView) itemView.findViewById(R.id.title);
            title.setBackgroundColor(Color.argb(0, 0, 0, 0));
        }
    }

    public IndexAdapter.IndexViewHolder onCreateViewHolder(ViewGroup viewGroup,int i){
        View v= LayoutInflater.from(context).inflate(R.layout.index_list,viewGroup,false);
        IndexViewHolder nvh=new IndexViewHolder(v);
        return nvh;
    }

    public void onBindViewHolder(IndexAdapter.IndexViewHolder IndexViewHolder, int i) {
        final int j=i;
        final String imageUrl =news.get(i).getUrl();
        IndexViewHolder.title.setText(news.get(i).getTitle());
        Uri uri = Uri.parse(imageUrl);
        IndexViewHolder.photo.setImageURI(uri);

        IndexViewHolder.index_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=news.get(j).getTitle();
                String content=news.get(j).getContent();
                Intent intent=new Intent(context,ContentNews.class);
                intent.putExtra("title",title);
                intent.putExtra("content",content);
                intent.putExtra("url",imageUrl);
                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return news.size();
    }


}