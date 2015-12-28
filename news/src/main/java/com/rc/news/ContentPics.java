package com.rc.news;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.view.SimpleDraweeView;
import com.rc.news.adapter.PicAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;


/**
 * Created by melo.Rench on 2015/12/23.
 */
public class ContentPics extends AppCompatActivity {

    private PicListAdapter mAdapter;
    private RecyclerView recyclerView;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_pic);

        recyclerView = (RecyclerView) findViewById(R.id.content_pic_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);


        Intent intent=getIntent();

//        FragmentPic.PicSerializable urlList1=(FragmentPic.PicSerializable)intent.getSerializableExtra("picList");


//        String[] urlList=urlList1.getUrl();
        String[] urlList=intent.getStringArrayExtra("picList");
//        Log.e("urlList", "--urlList----PicSerializable-----------" + urlList);

        mAdapter=new PicListAdapter(urlList,this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);




    }





    public class PicListAdapter extends RecyclerView.Adapter<PicListAdapter.PicListViewHolder>{

//        private List<PicListSerializable>  piclist;
        private String[] piclist;
        private Context context;
         public PicListAdapter(String[] urlList,Context context){
             this.piclist=urlList;
             this.context = context;


         }

        public class PicListViewHolder extends RecyclerView.ViewHolder{
             SimpleDraweeView content_photo;

            public PicListViewHolder(final View itemview){
                super(itemview);
                content_photo=(SimpleDraweeView)itemview.findViewById(R.id.pic_content_photo);

            }

        }
        public PicListViewHolder onCreateViewHolder(ViewGroup viewGroup,int i){
            View v= LayoutInflater.from(context).inflate(R.layout.content_pic_list,viewGroup,false);
            PicListViewHolder nvh=new PicListViewHolder(v);
            return nvh;
        }

        public void onBindViewHolder(PicListViewHolder picListViewHolder, int i){

//            final String[] url_list1=piclist.get(i).getUrl();
            Log.e("url_list1", "........" + piclist.length);
            Uri uri = Uri.parse(piclist[i]);
            for(int m=0;m<piclist.length;m++){
                System.out.println("onbindviewholder"+piclist[m]);
            }
            picListViewHolder.content_photo.setImageURI(uri);

        }

        public int getItemCount(){
            return piclist.length;
        }

    }
}



