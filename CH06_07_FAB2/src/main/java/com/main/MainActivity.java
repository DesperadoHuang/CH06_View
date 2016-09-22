package com.main;

import android.graphics.Outline;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean play;
    private TextView textView;
    private ImageButton imageButtonFAB;
    private String article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        imageButtonFAB = (ImageButton) findViewById(R.id.imageButton);
        article = getResources().getString(R.string.article);

        imageButtonFAB.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int size = getResources().getDimensionPixelSize(R.dimen.fab_size);
                outline.setOval(size, size, size, size);
            }
        });
        imageButtonFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButtonFAB.setImageResource(play ? R.drawable.play : R.drawable.pause);
                play = !play;
                new Marquee().start();
            }
        });

    }

    private class Marquee extends Thread {
        int length = 0;
        int maxLength = article.length();

        Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                String msgString = (String) msg.obj;
                Log.i("myDebug", msgString);
                textView.setText(msgString);
            }
        };

        @Override
        public void run() {
            if (length <= maxLength && play) {
                play();
            }

        }

        private void play() {
            length++;

            if (length <= maxLength && play) {
                String obj = (String) article.subSequence(0, length);
                Message message = handler.obtainMessage(1, obj);
                handler.sendMessageDelayed(message, 100);
                play();
            }
        }
    }
}
