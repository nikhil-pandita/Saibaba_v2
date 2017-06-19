package com.example.nikhil.saibabaxd;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.id;

public class ADevelopers extends AppCompatActivity {

    ImageView iv;
    TextView mLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adevelopers);
        mLink = (TextView) findViewById(R.id.textView);
        iv = (ImageView) findViewById(R.id.Imageviewer);
        iv.setImageResource(R.drawable.lions);

        if (mLink != null) {
            mLink.setMovementMethod(LinkMovementMethod.getInstance());
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    public void onWeb(View v){
        goToUrl("http://www.4liontechosolutions.com/");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
