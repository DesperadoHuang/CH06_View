package com.main;

import android.graphics.Outline;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 *
 */
public class MainActivity extends AppCompatActivity {
    private boolean play; //紀錄FAB的狀態
    private ImageButton imageButton_FAB;
    private TextView textView;
    private String article;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton_FAB = (ImageButton) findViewById(R.id.imageButton);
        textView = (TextView) findViewById(R.id.textView);
        article = getResources().getString(R.string.gueishan_island);

        //實作視圖外觀
        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                //設定視圖尺寸
                int size = getResources().getDimensionPixelSize(R.dimen.fab_size);
                //設定視圖外觀
                outline.setOval(0, 0, size, size);
            }
        };
        //設定FAB外框樣式
        imageButton_FAB.setOutlineProvider(viewOutlineProvider);
        //註冊FAB的onClick事件
        imageButton_FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //變更FAB圖樣
                imageButton_FAB.setImageResource(play ? R.drawable.play : R.drawable.pause);
                //改變Play/Pause狀態
                play = !play;

                //啟動文字跑馬燈
                new Marquee().start();
            }
        });
    }

    //自製的文字跑馬燈
    private class Marquee extends Thread {
        int length = 0;
        int maxLength = article.length();
        private Handler handler = new Handler();
        private Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (length <= maxLength && play) {
                    textView.setText(article.subSequence(0, length));
                    play();
                }
            }
        };

        @Override
        public void run() {
            if (play) {
                play();
            }
        }

        private void play() {
            length++;
            handler.postDelayed(runnable, 100);
        }
    }
}
