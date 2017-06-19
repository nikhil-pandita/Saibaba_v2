package com.example.nikhil.saibabaxd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.nikhil.saibabaxd.Adapters.GridViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<String> temp = new ArrayList<String>();
        temp.add("About Sai");
        temp.add("About Mandir");
        temp.add("Trustee");
        temp.add("Gallery");
        temp.add("Map");
        temp.add("Mediaplayer");
        ExpandableHeightGridView gridView = new ExpandableHeightGridView(this);
        gridView = (ExpandableHeightGridView) findViewById(R.id.menu_grid);
        gridView.setNumColumns(2);
        gridView.setAdapter(new GridViewAdapter(temp,getApplicationContext()));
        gridView.setExpanded(true);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                System.out.println(position);
                if (position==0)
                {

                    Intent Intent = new Intent(view.getContext(), ASai.class);
                    startActivity(Intent);
                }
                if (position==1){
                    Intent Intent = new Intent(view.getContext(), AMandir.class);
                    startActivity(Intent);
                }
                if (position==2)
                {
                   /* Intent Intent = new Intent(view.getContext(), AGallery.class);
                    startActivity(Intent);*/
                }
                if (position==3)
                {
                    Intent Intent = new Intent(view.getContext(), AGallery.class);
                    startActivity(Intent);
                }
                if (position==4)
                {
                    Intent Intent = new Intent(view.getContext(), AMapss.class);
                    startActivity(Intent);
                }
                if (position==5)
                {
                    Intent Intent = new Intent(view.getContext(),Mediaplayer.class);
                    startActivity(Intent);
                }
                /* if (position==2)
            {
                Intent Intent = new Intent(view.getContext(), AGallery.class);
                startActivity(Intent);
            }*/
                }

        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.develop){
            Intent i=new Intent(MainActivity.this,ADevelopers.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}