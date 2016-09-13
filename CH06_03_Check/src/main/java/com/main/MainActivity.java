package com.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBox;
    private CheckedTextView checkedTextView;
    private RadioGroup radioGroup;
    private Switch aSwitch;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;


        checkBox = (CheckBox) findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(context, buttonView.getText().toString() + "：" + String.valueOf(isChecked), Toast.LENGTH_SHORT).show();
            }
        });

        checkedTextView = (CheckedTextView) findViewById(R.id.checkedTextView);
        checkedTextView.setClickable(true);//開啟onClick事件，但設為false似乎也沒差??
        checkedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckedTextView ctv = (CheckedTextView) v;
                ctv.setChecked(!ctv.isChecked());
                Toast.makeText(context, ctv.getText().toString() + "：" + ctv.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        Toast.makeText(context, R.string.radioButton_man, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(context, R.string.radioButton_woman, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        aSwitch = (Switch) findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(context, buttonView.getText().toString() + "：" + isChecked, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
