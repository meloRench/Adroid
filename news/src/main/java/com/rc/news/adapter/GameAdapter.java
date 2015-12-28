package com.rc.news.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rc.news.FragmentGame;
import com.rc.news.R;

import java.util.List;

/**
 * Created by root on 15-12-16.
 */
public class GameAdapter extends RecyclerView.Adapter<GameAdapter.MyViewHolder> {

    List<FragmentGame.GameSerializable> gamedata;


    public GameAdapter( List<FragmentGame.GameSerializable> gamedata){
        this.gamedata=gamedata;

    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
//        TextView title;
        TextView game_list_name;
        TextView game_text1; TextView game_text01;
        TextView game_text2; TextView game_text02;
        TextView game_text3; TextView game_text03;
        TextView game_text4; TextView game_text04;
        TextView game_text5; TextView game_text05;
        TextView game_text6; TextView game_text06;


        public MyViewHolder(View itemView){
            super(itemView);
//            title=(TextView)itemView.findViewById(R.id.game_list_name);
            game_list_name=(TextView)itemView.findViewById(R.id.game_list_name);
            game_text1=(TextView)itemView.findViewById(R.id.game_text1); game_text01=(TextView)itemView.findViewById(R.id.game_text01);
            game_text2=(TextView)itemView.findViewById(R.id.game_text2); game_text02=(TextView)itemView.findViewById(R.id.game_text02);
            game_text3=(TextView)itemView.findViewById(R.id.game_text3); game_text03=(TextView)itemView.findViewById(R.id.game_text03);
            game_text4=(TextView)itemView.findViewById(R.id.game_text4); game_text04=(TextView)itemView.findViewById(R.id.game_text04);
            game_text5=(TextView)itemView.findViewById(R.id.game_text5); game_text05=(TextView)itemView.findViewById(R.id.game_text05);
            game_text6=(TextView)itemView.findViewById(R.id.game_text6); game_text06=(TextView)itemView.findViewById(R.id.game_text06);
      /*
      *
      * */
        }


    }




    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_list,
                viewGroup, false);
        return new MyViewHolder(view);
    }

    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        String[][] data=gamedata.get(i).getData();
//        myViewHolder.title.setText(data[0][1]);
        myViewHolder.game_list_name.setText(data[0][0]);
        myViewHolder.game_text1.setText(data[1][0]); myViewHolder.game_text01.setText(data[1][1]);
        myViewHolder.game_text2.setText(data[2][0]); myViewHolder.game_text02.setText(data[2][1]);
        myViewHolder.game_text3.setText(data[3][0]); myViewHolder.game_text03.setText(data[3][1]);
        myViewHolder.game_text4.setText(data[4][0]); myViewHolder.game_text04.setText(data[4][1]);
        myViewHolder.game_text5.setText(data[5][0]); myViewHolder.game_text05.setText(data[5][1]);
        myViewHolder.game_text6.setText(data[6][0]); myViewHolder.game_text06.setText(data[6][1]);
    /*
    *
    *
    * */
    }

    @Override
    public int getItemCount() {
        return gamedata.size();
    }



}