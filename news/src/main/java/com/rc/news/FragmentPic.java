package com.rc.news;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
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
import com.rc.news.adapter.IndexAdapter;
import com.rc.news.adapter.PicAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

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
    private RecyclerView recyclerView;
    private String[] url_list;

    private Handler handler=new Handler() {


        public void handleMessage(Message msg)
        {
            if (msg.what==0x01)
            {
//                         newsList=(List<IndexSerializable>)msg.obj;
                Log.e("pic","--pic---------------"+picsList.size());
                mAdapter = new PicAdapter(picsList,getActivity());
                recyclerView.setAdapter(mAdapter);
                recyclerView.setHasFixedSize(true);

            }
        }

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pic,container,false);

         recyclerView = (RecyclerView) view.findViewById(R.id.fragment_pic_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        picsList =new ArrayList<>();
        JsonArray();

       /* picsList.add(new PicSerializable("点击进入图集",R.mipmap.nba_1));
        picsList.add(new PicSerializable("点击进入图集",R.mipmap.nba_2));
        picsList.add(new PicSerializable("点击进入图集",R.mipmap.nba_3));
        picsList.add(new PicSerializable("点击进入图集", R.mipmap.nba_4));
        picsList.add(new PicSerializable("点击进入图集", R.mipmap.nba_7));

        String[] listItems = mItemData.split(" ");

        List<String> list = new ArrayList<>();
        Collections.addAll(list, listItems);*/

       /* mAdapter = new PicAdapter(picsList,getActivity());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
*/
        return view;
    }


    public class PicSerializable implements Serializable{

        private String[] url;

        public PicSerializable(String[] url){
            this.url=url;
        }

        public String[] getUrl() {
            return url;
        }
        public void setUrl(String[] url){
            this.url=url;
        }
    }


    public void JsonArray(){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        String JSONDateUrl = "http://1.payrc.sinaapp.com/2001.json";
        JsonObjectRequest jsonObjectrequest = new JsonObjectRequest(
                Request.Method.GET, JSONDateUrl, null,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        try{
                            JSONArray pic=response.getJSONArray("pic");
                            System.out.println("response=" + pic);
                            Log.d("Json", pic.toString());
//                            List<IndexSerializable> newsList1;////
                            for (int i = 0; i < pic.length(); i++) {
                                JSONObject jo = pic.getJSONObject(i);
                                JSONArray url_list1 = jo.getJSONArray("url_list");
                                url_list =new String[url_list1.length()];
                                for(int j=0;j<url_list1.length();j++){
                                    JSONObject jo1 = url_list1.getJSONObject(j);
//                                    System.out.println("url_list1=" + url_list1.getJSONObject(j));
                                    url_list[j]=jo1.getString("url");
//                                     ArrayList url_list=new ArrayList();
//                                     url_list.add(jo1.getString("url"));

                                }
//                                picsList=new ArrayList<PicSerializable>();//////
                                picsList.add(new PicSerializable(url_list));/////
                                Log.e("pic", "--piclist---------------" + picsList.size());
                                Message msg=new Message();
//                                msg.obj=newsList1;
                                msg.what=0x01;
                                handler.sendMessage(msg);

                            }
                        }catch (Exception e){}

                    }
                }, new Response.ErrorListener() {
            public void onErrorResponse(
                    com.android.volley.VolleyError arg0) {
                System.out.println("pic有问题");
            }
        });
        requestQueue.add(jsonObjectrequest);
    }




}
