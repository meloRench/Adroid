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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.rc.news.ContentPics;
import com.rc.news.FragmentPic;
import com.rc.news.FragmentPic.PicSerializable;
import com.rc.news.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 15-12-16.
 */
public class PicAdapter extends RecyclerView.Adapter<PicAdapter.PicViewHolder> {


    private List<PicSerializable> pics;

    private Context context;

    static class PicViewHolder extends RecyclerView.ViewHolder {

        CardView pic_list;
//        ImageView photo;
        SimpleDraweeView photo;
        TextView title;
        Button share;
        Button like;
        public  PicViewHolder(final View itemView) {
            super(itemView);
            pic_list = (CardView) itemView.findViewById(R.id.pic_list);
//            photo = (ImageView) itemView.findViewById(R.id.photo);
            photo = (SimpleDraweeView) itemView.findViewById(R.id.pic_list_photo);
            title=(TextView)itemView.findViewById(R.id.pic_list_title);
            share = (Button) itemView.findViewById(R.id.btn_share);
            like = (Button) itemView.findViewById(R.id.btn_like);
            title.setBackgroundColor(Color.argb(20, 0, 0, 0));
        }

    }
    public PicAdapter(List<PicSerializable> pics, Context context){
        this.context = context;
        this.pics=pics;
    }

    public PicAdapter.PicViewHolder onCreateViewHolder(ViewGroup viewGroup,int i){
        View v= LayoutInflater.from(context).inflate(R.layout.pic_list,viewGroup,false);
        PicViewHolder nvh=new PicViewHolder(v);
        return nvh;
    }
    @Override
    public void onBindViewHolder(PicAdapter.PicViewHolder picViewHolder, int i) {

        final int j=i;
        final String[] url_list1=pics.get(i).getUrl();
      /*  Log.e("url_list1", "........" + url_list1.length);
        for(int m=0;m<url_list1.length;m++){
            System.out.println(url_list1[m]);
        }*/

//        picViewHolder.photo.setImageResource(pics.get(i).getPhotoId());
        picViewHolder.title.setText("点击进入图集");
        Uri uri = Uri.parse(url_list1[2]);
        picViewHolder.photo.setImageURI(uri);



        picViewHolder.pic_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ContentPics.class);
                intent.putExtra("picList",pics.get(j).getUrl());
                context.startActivity(intent);
                Log.e("putExtra", "------putExtra-----------" + pics.get(j));
            }
        });





    }

    @Override
    public int getItemCount() {
        return pics.size();
    }
}
