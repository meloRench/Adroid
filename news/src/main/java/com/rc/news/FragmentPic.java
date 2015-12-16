package com.rc.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rc.news.adapter.PicAdapter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * Created by root on 15-12-15.
 */
public class FragmentPic extends Fragment {

    private List<FragmentPic.PicSerializable> picsList;
    private PicAdapter mAdapter;

    private String mItemData = "并没有什么卵用~ 并没有什么卵用~ 并没有什么卵用~ 并没有什么卵用~ 并没有什么卵用~ 并没有什么卵用~ 并没有什么卵用~ 并没有什么卵用~ 并没有什么卵用~";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pic,container,false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_pic_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        picsList =new ArrayList<>();

        picsList.add(new PicSerializable("nba",R.mipmap.nba_1));
        picsList.add(new PicSerializable("nba",R.mipmap.nba_2));
        picsList.add(new PicSerializable("nba",R.mipmap.nba_3));
        picsList.add(new PicSerializable("nba", R.mipmap.nba_4));
        picsList.add(new PicSerializable("nba", R.mipmap.nba_7));

        String[] listItems = mItemData.split(" ");

        List<String> list = new ArrayList<>();
        Collections.addAll(list, listItems);

        mAdapter = new PicAdapter(picsList,getActivity());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }


    public class PicSerializable implements Serializable {

        private String title;
        private int photoId;

        public PicSerializable(String name,int photoId){
            this.title=name;
            this.photoId=photoId;
        }

        public void setTitle(String title) {
            this.title = title;
        }


        public void setPhotoId(int photoId) {
            this.photoId = photoId;
        }

        public int getPhotoId() {
            return photoId;
        }



        public String getTitle() {
            return title;
        }
    }




}
