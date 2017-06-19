package com.example.nikhil.saibabaxd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.nikhil.saibabaxd.Adapters.GridViewAdapter;
import com.example.nikhil.saibabaxd.Adapters.GridViewAdapter_IMG;
import com.example.nikhil.saibabaxd.ExpandableHeightGridView;
import com.example.nikhil.saibabaxd.R;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.ArrayList;

public class AGallery extends AppCompatActivity {

    public int[] imgarr = {R.drawable.saibaba1, R.drawable.saibaba2, R.drawable.saibaba3};//used to input images inside app
    public final static String url = "http://www.car-ing.com/app/Get_Gallery.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agallery);

        Volleypostfunc(url);

        /*ArrayList<String> temp = new ArrayList<String>();
        temp.add("http://pngimagesfree.com/God/sai_baba_png/sai_baba_png_image_one.png");
        temp.add("http://pngimagesfree.com/God/sai_baba_png/sai_baba_png_image_three.png");
        temp.add("http://pngimagesfree.com/God/sai_baba_png/sai_baba_png_image_two.png");*/
/*
        temp.add("https://www.google.co.in/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwjoisr-3IrUAhWIPo8KHf2PA90QjRwIBw&url=http%3A%2F%2Fpngimagesfree.com%2FGod%2Fsai_baba-png.htm&psig=AFQjCNGjYQ0EFqiIKtAuXtikoubd_xpdYg&ust=1495790709489582");
*/




       /* ExpandableHeightGridView gridView = new ExpandableHeightGridView(this);
        gridView = (ExpandableHeightGridView) findViewById(R.id.menu_grid);
        gridView.setNumColumns(2);
        gridView.setAdapter(new GridViewAdapter(temp,getApplicationContext()));
        gridView.setExpanded(true);*/
    }

    public void Volleypostfunc(String posturl)
    { final ArrayList<HashMap<String, String>> arrayList = new ArrayList<HashMap<String,String>>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, posturl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response!=null)
                {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        JSONArray jsonArray = jsonObject.getJSONArray("Image_Gallery");
                        if(jsonArray.length()>0)
                        {
                            for(int i =0; i<jsonArray.length();i++)
                            {
                                HashMap<String, String> h1 = new HashMap<String, String>();
                                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                Log.d("Insidehasmap",jsonObject1.getString("IMG_URL"));
                                h1.put("URL",jsonObject1.getString("IMG_URL"));
                                arrayList.add(h1);


                                ExpandableHeightGridView gridviewimg = new ExpandableHeightGridView(getApplicationContext());
                                gridviewimg = (ExpandableHeightGridView) findViewById(R.id.Imageviewer);
                                gridviewimg.setNumColumns(2);
                                gridviewimg.setAdapter(new GridViewAdapter_IMG(arrayList,getApplicationContext()));
                                gridviewimg.setExpanded(true);

                            }}




                    } catch (JSONException e) {

                        e.printStackTrace();
                    }


                }
                Log.d("array_size",""+arrayList.size());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error",""+error.getMessage());
            }
        });
        requestQueue.add(stringRequest);

    }

}
