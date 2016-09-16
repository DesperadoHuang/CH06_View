package com.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(context, R.array.languages, android.R.layout.simple_spinner_item);

        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayAdapter);
    }
}
