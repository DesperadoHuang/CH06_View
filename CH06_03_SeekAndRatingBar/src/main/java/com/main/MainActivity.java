package com.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private SeekBar seekBar;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_seekBarValue:
                Toast.makeText(context, "SeekBarValue : " + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_ratingBarValue:
                Toast.makeText(context, "RatingBarValue : " + ratingBar.getProgress(), Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
