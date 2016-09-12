package com.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Context context;

    private String[] planetsArray = {"水星", "金星", "地球", "火星", "木星", "土星", "天王星", "海王星"};
    private String[][] countries = {{"台灣", "+886"}, {"日本", "+81"}, {"韓國", "+82"}, {"泰國", "+66"}, {"印尼", "+62"}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        //宣告型
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object o = parent.getItemAtPosition(position);
                Toast.makeText(context, "選擇" + o, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //java實作型
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> planetsAdapter = new ArrayAdapter<String>(
                context,
                android.R.layout.simple_spinner_item,
                planetsArray);
        planetsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(planetsAdapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object o = parent.getItemAtPosition(position);
                Toast.makeText(context, "選擇" + o, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //java實作型-sub item
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (String[] country : countries) {
            Map<String, String> map = new HashMap<String, String>(2);
            map.put("country_name", country[0]);
            map.put("country_code", country[1]);
            data.add(map);
        }

        SimpleAdapter countryAdapter = new SimpleAdapter(
                context,
                data,
                android.R.layout.simple_list_item_2,
                new String[]{"country_name", "country_code"},
                new int[]{android.R.id.text1, android.R.id.text2}
        );

        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(countryAdapter);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Map<String, String> map = (Map<String, String>) parent.getItemAtPosition(position);
                Toast.makeText(context, "country_name:" + map.get("country_name") + " " +
                        "country_code:" + map.get("country_code"), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
