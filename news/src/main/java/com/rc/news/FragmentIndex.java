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

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by root on 15-12-15.
 */
public class FragmentIndex extends Fragment {

    private List<IndexSerializable> newsList;
    private IndexAdapter mAdapter;
    private RecyclerView recyclerView;

    private Handler  handler=new Handler() {


        public void handleMessage(Message msg)
        {
            if (msg.what==0x01)
            {
//                         newsList=(List<IndexSerializable>)msg.obj;
                Log.e("123","------------------------"+newsList.size());
                mAdapter = new IndexAdapter(newsList,getActivity());
                recyclerView.setAdapter(mAdapter);
                recyclerView.setHasFixedSize(true);

            }
        }

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_index, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_index_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        newsList =new ArrayList<>();

       /* picList.add(new IndexSerializable("年迈邓肯，宣布本赛季结束退役",R.mipmap.nba_1));
        picList.add(new IndexSerializable("科比成功登顶NBA得分王宝座",R.mipmap.nba_2));
        picList.add(new IndexSerializable("克里斯保罗遗憾伤退，宣布退役",R.mipmap.nba_3));
        picList.add(new IndexSerializable("安东尼宣布以自由球员身份加入洛杉矶湖人队", R.mipmap.nba_4));
        picList.add(new IndexSerializable("疑似队伍不和，马刺替补席大打出手", R.mipmap.nba_7));*/

/*

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        String JSONDateUrl = "http://1.payrc.sinaapp.com/1002.json";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, JSONDateUrl, null,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        System.out.println("response=" + response);
                        Log.d("Json", response.toString());
                        List<IndexSerializable> newsLis;
                        try{
                            String title = response.getString("title");
                            newsLis=new ArrayList<IndexSerializable>();
                            newsLis.add(new IndexSerializable(title, R.mipmap.nba_7));

                            Message msg=new Message();
                            msg.obj=newsLis;
                            msg.what=0x01;
                            handler.sendMessage(msg);

                        }catch (Exception e){}
                    }
                }, new Response.ErrorListener() {
            public void onErrorResponse(
                    com.android.volley.VolleyError arg0) {
                System.out.println("有问题");
            }
        });
        requestQueue.add(jsonObjectRequest);
*/

        JsonArray();
//        getJson();
        return view;
    }


    public class IndexSerializable implements Serializable {

        private String title;
        private int photoId;
        private String url;
        private String content;


        public IndexSerializable(String title,String  url,String content){
            this.title=title;
            this.url=url;
            this.content=content;
        }


        public void setUrl(String url){
            this.url=url;

        }

        public String getUrl(){
            return url;
        }
  /*
        public IndexSerializable(String name,int photoid){
            this.title=name;
            this.photoId=photoid;
        }

        public void setPhotoId(int photoId) {
            this.photoId = photoId;
        }



        public int getPhotoId() {
            return photoId;
        }
        */

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

    }

    public void JsonArray(){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        String JSONDateUrl = "http://1.payrc.sinaapp.com/1008.json";
        JsonObjectRequest jsonObjectrequest = new JsonObjectRequest(
                Request.Method.GET, JSONDateUrl, null,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        try{
                            JSONArray newsInfo=response.getJSONArray("news");
                            System.out.println("response=" + newsInfo);
                            Log.d("Json", newsInfo.toString());
                            for (int i = 0; i < newsInfo.length(); i++) {
                                JSONObject jo = newsInfo.getJSONObject(i);
                                String title = jo.getString("title");
                                String url = jo.getString("url");
                                String content =jo.getString("content");
                                newsList.add(new IndexSerializable(title,url,content));
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
                System.out.println("有问题");
            }
        });
        requestQueue.add(jsonObjectrequest);
    }

  /*  public class getJson{
        public void getJson(){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        String JSONDateUrl = "http://1.payrc.sinaapp.com/1002.json";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, JSONDateUrl, null,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        System.out.println("response=" + response);
                        Log.d("Json", response.toString());

                        try{
                            String title = response.getString("title");
                            newsList.add(new IndexSerializable(title,title));


                        }catch (Exception e){}
                    Message msg=new Message();
                            msg.what=0x01;
                        handler.sendMessage(msg);
                    }
                }, new Response.ErrorListener() {
            public void onErrorResponse(
                    com.android.volley.VolleyError arg0) {
                System.out.println("有问题");
            }
        });
        requestQueue.add(jsonObjectRequest);
        }

    }*/
/*

    public class getImage{
//        private String imageUrl;
//        private NetworkImageView photo;
        private RequestQueue requestQueue;
        private ImageLoader imageLoader;
        public  getImage(){
//             this.photo=photo;
//            this.imageUrl=imageUrl;
//        String imageUrl = "http://c2.hoopchina.com.cn/uploads/star/event/images/151217/614833907de614df0a9111c348a554c760835165.png";
             requestQueue = Volley.newRequestQueue(getActivity());
            final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(1000);
            ImageLoader.ImageCache imageCache = new ImageLoader.ImageCache() {

                @Override
                public void putBitmap(String key, Bitmap value) {
                    lruCache.put(key, value);
                }

                @Override
                public Bitmap getBitmap(String key) {
                    return lruCache.get(key);
                }
            };
           imageLoader = new ImageLoader(requestQueue, imageCache);
     */
/*         photo.setErrorImageResId(R.mipmap.ic_launcher);
            photo.setTag("url");
            photo.setImageUrl(imageUrl, imageLoader);*//*



//        IndexViewHolder.photo.setImageResource(pic.get(i).geturl());
//        IndexViewHolder.photo.setImageUrl(url,imageLoader);
//            IndexViewHolder.title.setText(pic.get(i).getTitle());
        }

        public ImageLoader getImageLoader(){
            return imageLoader;
        }
    }

*/




}




