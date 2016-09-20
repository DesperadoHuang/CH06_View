package com.main;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {
    private Context context;
    private MediaController mediaController;
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        videoView = (VideoView) findViewById(R.id.videoView);
        mediaController = new MediaController(context);

        String localPath = "android.resource://" + getPackageName() + "/" + R.raw.test;
        String webPaht = getResources().getString(R.string.rstp);

        Uri uri = Uri.parse(localPath);
        Log.i("WilsonHuang", uri.toString());

        videoView.setVideoURI(uri);
        videoView.setMediaController(mediaController);
    }

}
