package com.example.nikhil.saibabaxd;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.h6ah4i.android.media.IBasicMediaPlayer;
import com.h6ah4i.android.media.IMediaPlayerFactory;
import com.h6ah4i.android.media.opensl.OpenSLMediaPlayerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Mediaplayer extends AppCompatActivity {


    public final static String AUDIO_URL = "audio_url";
    public final static String IMG_URL = "image_url";
    Context cont;
    URL url;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);

        openPlayer(view);

       /* IMediaPlayerFactory factory = new OpenSLMediaPlayerFactory(getApplicationContext());
        IBasicMediaPlayer player = factory.createMediaPlayer();
        System.out.println("Workss");
        try {
            player.setDataSource("http://www.car-ing.com/song.mp3");
            player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // start playback
        player.start();
*/
        /* cont = this;
        URL url = new URL("http://www.google.com"); //Some instantiated URL object
        try {
            URI uri = url.toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }*/
    }

    public void openPlayer(View view) {
        Intent intent = new Intent(this, URLMediaPlayerActivity.class);
        intent.putExtra(AUDIO_URL, "http://www.car-ing.com/song.mp3");
        intent.putExtra(IMG_URL, "http://www.car-ing.com/pic.jpg");
        startActivity(intent);
    }
}