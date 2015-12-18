package com.rc.news.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rc.news.FragmentIndex;
import com.rc.news.R;

import java.util.List;

/**
 * Created by root on 15-12-16.
 */
public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.IndexViewHolder> {


    private List<FragmentIndex.IndexSerializable> pic;
    private Context context;

    static class IndexViewHolder extends RecyclerView.ViewHolder {

        CardView pic_list;
        ImageView photo;
        TextView title;

        public  IndexViewHolder(final View itemView) {
            super(itemView);
            pic_list = (CardView) itemView.findViewById(R.id.pic_list);
            photo = (ImageView) itemView.findViewById(R.id.photo);
            title = (TextView) itemView.findViewById(R.id.title);

            title.setBackgroundColor(Color.argb(0, 0, 0, 0));
        }

    }
    public IndexAdapter(List<FragmentIndex.IndexSerializable> pic, Context context){
        this.context = context;
        this.pic = pic;
    }

    public IndexAdapter.IndexViewHolder onCreateViewHolder(ViewGroup viewGroup,int i){
        View v= LayoutInflater.from(context).inflate(R.layout.index_list,viewGroup,false);
        IndexViewHolder nvh=new IndexViewHolder(v);
        return nvh;
    }
    @Override
    public void onBindViewHolder(IndexAdapter.IndexViewHolder IndexViewHolder, int i) {
        final int j=i;

        IndexViewHolder.photo.setImageResource(pic.get(i).getPhotoId());
        IndexViewHolder.title.setText(pic.get(i).getTitle());



    }

    @Override
    public int getItemCount() {
        return pic.size();
    }
}