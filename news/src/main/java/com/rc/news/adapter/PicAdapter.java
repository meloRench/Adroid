package com.rc.news.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rc.news.FragmentPic;
import com.rc.news.FragmentPic.PicSerializable;
import com.rc.news.R;

import java.util.List;

/**
 * Created by root on 15-12-16.
 */
public class PicAdapter extends RecyclerView.Adapter<PicAdapter.PicViewHolder> {


    private List<PicSerializable> pics;
    private Context context;

    static class PicViewHolder extends RecyclerView.ViewHolder {

        CardView pic_list;
        ImageView photo;
        TextView title;
        Button share;
        Button like;
        public  PicViewHolder(final View itemView) {
            super(itemView);
            pic_list = (CardView) itemView.findViewById(R.id.pic_list);
            photo = (ImageView) itemView.findViewById(R.id.photo);
            title = (TextView) itemView.findViewById(R.id.title);
            share = (Button) itemView.findViewById(R.id.btn_share);
            like = (Button) itemView.findViewById(R.id.btn_like);
            //设置TextView背景为半透明
            title.setBackgroundColor(Color.argb(20, 0, 0, 0));
        }

    }
    public PicAdapter(List<FragmentPic.PicSerializable> pics, Context context){
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

        picViewHolder.photo.setImageResource(pics.get(i).getPhotoId());
        picViewHolder.title.setText(pics.get(i).getTitle());
/*

        //为btn_share btn_readMore cardView设置点击事件
        picViewHolder.pic_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,NewsActivity.class);
                intent.putExtra("News",pics.get(j));
                context.startActivity(intent);
            }
        });

        picViewHolder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "分享");
                intent.putExtra(Intent.EXTRA_TEXT, newses.get(j).getDesc());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Intent.createChooser(intent, newses.get(j).getTitle()));
            }
        });

        picViewHolder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsActivity.class);
                intent.putExtra("News", pics.get(j));
                context.startActivity(intent);
            }
        });
*/


    }

    @Override
    public int getItemCount() {
        return pics.size();
    }
}
