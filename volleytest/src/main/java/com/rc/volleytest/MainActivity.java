package com.rc.volleytest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class MainActivity extends Activity {

//    private ImageView iv1;
    private TextView text;
    private NetworkImageView iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {

        text = (TextView)findViewById(R.id.tv);
//        iv1 = (ImageView) findViewById(R.id.iv);
        iv2 = (NetworkImageView) findViewById(R.id.imageView);

       getJSONVolley();
//        getStringVolley();
        NetWorkImageViewVolley();
//        getJsonObject();
    }

    public void getStringVolley(){
        RequestQueue mQueue =Volley.newRequestQueue(this);
        String StringDtaUrl1 = "http://1.mypyrc.sinaapp.com/1001.html";
        String StringDtaUrl2 = "http://cn.bing.com/";
        String StringDtaUrl = "http://1.payrc.sinaapp.com/1001.html";
        StringRequest stringRequest = new StringRequest(StringDtaUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("StringVolley", response);
                        String content =response.toString();
                        text.setText(content);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });/*
        StringRequest stringRequest =new StringRequest(
                StringDtaaUrl,new Response.Listener<String>(){
            public void onResponse(String reponse){
                Log.d("SringVolley",reponse);
            },new Response.ErrorListener(){
                public void onErrorResponse(VolleyError ){}

                }
            }
        }
        );*/
        mQueue.add(stringRequest);
    }
    public void getJSONVolley() {


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String JSONDateUrl = "http://1.payrc.sinaapp.com/1002.json";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, JSONDateUrl, null,
                new Response.Listener<JSONObject>() {
                    public void onResponse(JSONObject response) {
                        System.out.println("response=" + response);
                        Log.d("Json",response.toString());
//                        String content =(String)response;
                        String content =response.toString();
                        text.setText(content);
                    }
                }, new Response.ErrorListener() {
            public void onErrorResponse(
                    com.android.volley.VolleyError arg0) {
                System.out.println("对不起，有问题");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
/*

    public void getJsonObject(){
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(WEATHER_LINK, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject arg0) {
                            list.clear();
                            Iterator<String> it = arg0.keys();
                            while(it.hasNext()){
                                String key = it.next();
                                JSONObject obj = null;
                                try {
                                    obj = arg0.getJSONObject(key);
                                } catch (JSONException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                                if (obj != null) {
                                    Iterator<String> objIt = obj.keys();
                                    while (objIt.hasNext()) {
                                        String objKey = objIt.next();
                                        String objValue;
                                        try {
                                            objValue = obj.getString(objKey);
                                            HashMap<String, String> map = new HashMap<String, String>();
                                            map.put("title", objKey);
                                            map.put("content", objValue);
                                            Log.v(TAG, "title = " + objKey + " | content = " + objValue);
                                            list.add(map);
                                        } catch (JSONException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                            Log.v(TAG, "list.size = " + list.size());
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError arg0) {
                }
            });
            mQueue.add(jsonObjectRequest);
    }


*/


    public void NetWorkImageViewVolley(){
        String imageUrl = "http://c2.hoopchina.com.cn/uploads/star/event/images/151217/614833907de614df0a9111c348a554c760835165.png";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        final LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(1000);
        ImageCache imageCache = new ImageCache() {

            @Override
            public void putBitmap(String key, Bitmap value) {
                lruCache.put(key, value);
            }

            @Override
            public Bitmap getBitmap(String key) {
                return lruCache.get(key);
            }
        };
        ImageLoader imageLoader = new ImageLoader(requestQueue, imageCache);
        iv2=(NetworkImageView)findViewById(R.id.imageView);
        iv2.setErrorImageResId(R.mipmap.ic_launcher);
        iv2.setTag("url");
        iv2.setImageUrl(imageUrl, imageLoader);
    }

    public void NetWorkImageViewVolley2(){

        String imageUrl = "http://c2.hoopchina.com.cn/uploads/star/event/images/151217/614833907de614df0a9111c348a554c760835165.png";
        RequestQueue mQueue = Volley.newRequestQueue(this);
        ImageLoader imageLoader=new ImageLoader(mQueue, new ImageCache() {
            @Override
            public Bitmap getBitmap(String s) {
                return null;
            }

            @Override
            public void putBitmap(String s, Bitmap bitmap) {

            }
        });

        iv2=(NetworkImageView)findViewById(R.id.imageView);
        iv2.setErrorImageResId(R.mipmap.ic_launcher);
        iv2.setImageUrl(imageUrl,imageLoader);
    }
}