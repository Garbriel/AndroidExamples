package com.example.myexample.WebView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.example.myexample.R;
import com.example.myexample.R.layout;

public class WebView_04_Activity extends Activity implements View.OnClickListener {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_webview_04);

        webView = (WebView) findViewById(R.id.webView);
        Button btnWeb = (Button) findViewById(R.id.btnWeb);
        Button btnCurrent = (Button) findViewById(R.id.btnCurrent);

        webView.setWebViewClient(new WebViewClient());


        btnWeb.setOnClickListener(this);
        btnCurrent.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnWeb:
                webView.loadUrl("http://www.naver.com");
                break;
            case R.id.btnCurrent:
                Toast.makeText(this, webView.getUrl(), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack())
            webView.goBack();
        else
            super.onBackPressed();

    }
}