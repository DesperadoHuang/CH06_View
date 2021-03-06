package com.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private WebView webView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        editText = (EditText) findViewById(R.id.editText);
        webView = (WebView) findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);//開啟支援JavaScript
        webView.getSettings().setSupportZoom(true);//支援放大縮小
        webView.getSettings().setBuiltInZoomControls(true);//支援多點式觸控放大縮小

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                setTitle("Loading..." + newProgress + "%");
                setProgress(newProgress * 100);
                if (newProgress == 100) {
                    setTitle(R.string.app_name);
                    Toast.makeText(context, "網頁載入完成", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void onClick(View view) {
        String url=editText.getEditableText().toString();
        webView.loadUrl(url);
    }

}
