package com.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.QuickContactBadge;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleButton;
    private QuickContactBadge mailBadge;
    private QuickContactBadge phoneBadge;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(context, "狀態：" + isChecked, Toast.LENGTH_LONG).show();
            }
        });

        mailBadge = (QuickContactBadge) findViewById(R.id.mail_badge);
        mailBadge.assignContactFromEmail("abc@gmail.com", true);

        phoneBadge = (QuickContactBadge) findViewById(R.id.phone_badge);
        phoneBadge.assignContactFromPhone("0912345678", true);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Toast.makeText(context, R.string.button_text, Toast.LENGTH_LONG).show();
                break;
        }
    }
}
