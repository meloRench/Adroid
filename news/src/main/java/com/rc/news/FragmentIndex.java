package com.rc.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rc.news.adapter.IndexAdapter;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by root on 15-12-15.
 */
public class FragmentIndex extends Fragment {

    private List<FragmentIndex.IndexSerializable> picList;
    private IndexAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_index,container,false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_index_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        picList =new ArrayList<>();

        picList.add(new IndexSerializable("年迈邓肯，宣布本赛季结束退役",R.mipmap.nba_1));
        picList.add(new IndexSerializable("科比成功登顶NBA得分王宝座",R.mipmap.nba_2));
        picList.add(new IndexSerializable("克里斯保罗遗憾伤退，宣布退役",R.mipmap.nba_3));
        picList.add(new IndexSerializable("安东尼宣布以自由球员身份加入洛杉矶湖人队", R.mipmap.nba_4));
        picList.add(new IndexSerializable("疑似队伍不和，马刺替补席大打出手", R.mipmap.nba_7));


        mAdapter = new IndexAdapter(picList,getActivity());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }


    public class IndexSerializable implements Serializable {

        private String title;
        private int photoId;

        public IndexSerializable(String name,int photoId){
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




