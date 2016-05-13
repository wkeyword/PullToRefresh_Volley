package com.wangchangzheng.volleydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RequestQueue mRequestQueue;
    private ImageView iv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
//        String url="http://httpbin.org/html";
//        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.e(TAG, "onResponse: "+response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, "onErrorResponse: "+"加载失败" );
//            }
//        });




//        Volley.newRequestQueue(this).add(stringRequest);
//        String url="http://httpbin.org/get?site=code&network=tutsplus";
//        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
//                    response=response.getJSONObject("args");
//                    String site=response.getString("site");
//                    String network=response.getString("network");
//                    Log.e(TAG, "站点为"+site+"\n网络地址为："+network);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, "数据加载失败，请重试");
//            }
//        });
//        Volley.newRequestQueue(this).add(jsonObjectRequest);

        /*
        图片的获取方法
         */
//        iv1= (ImageView) findViewById(R.id.iv_1);
//
//        String url="http://i.imgur.com/Nwk25LA.jpg";
//        ImageRequest imageRequest=new ImageRequest(url, new Response.Listener<Bitmap>() {
//            @Override
//            public void onResponse(Bitmap response) {
//                iv1.setImageBitmap(response);
//            }
//        }, 0, 0, ImageView.ScaleType.FIT_XY, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                iv1.setBackgroundColor(Color.parseColor("#f00"));
//            }
//        });
//        Volley.newRequestQueue(this).add(imageRequest);


        //Post的获取方法

        String url="http://httpbin.org/post";

        StringRequest postRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse=new JSONObject(response).getJSONObject("form");
                    String site=jsonResponse.getString("site");
                    String network=jsonResponse.getString("network");
                    Log.e(TAG, site+network);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String, String>();
                params.put("site","code");
                params.put("network","tutsplus");
                return params;
            }
        };

        Volley.newRequestQueue(this).add(postRequest);



    }



}
