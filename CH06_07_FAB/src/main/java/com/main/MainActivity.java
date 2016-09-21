package com.main;

import android.graphics.Outline;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean play;
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

        ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                int size = getResources().getDimensionPixelSize(R.dimen.fab_size);
                outline.setOval(0, 0, size, size);
            }
        };
        imageButton_FAB.setOutlineProvider(viewOutlineProvider);
        imageButton_FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton_FAB.setImageResource(play ? R.drawable.play : R.drawable.pause);
                play = !play;
            }
        });
    }

    private class Marquee extends Thread {

    }
}
