package com.rc.news;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by root on 15-12-16.
 */
public class MyListAdapter  extends RecyclerView.Adapter<MyListAdapter.MyViewHolder>  {

    List<String> mListData;


    public MyListAdapter(List<String> mListData){
        this.mListData=mListData;

    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView title;

        public MyViewHolder(View itemView){
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.listitem_name);
        }


    }




    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list,
                viewGroup, false);
        return new MyViewHolder(view);
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(mListData.get(i));
    }

    @Override
    public int getItemCount() {
        return mListData == null ? 0 : mListData.size();
    }



}
