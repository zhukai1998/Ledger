package com.zhukai.ledger.module.main.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.zhukai.ledger.R;
import com.zhukai.ledger.bean.NetworkUtil;
import com.zhukai.ledger.module.component.BaseActivity;

public class ActivityAboutWeb extends BaseActivity {

    private WebView web;
    private ProgressBar bar;
    private boolean isNet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_web);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ActivityAboutWeb.this.finish();
            }
        });
        NetworkUtil net = new NetworkUtil(this);
        isNet = net.isNetworkAvailable();
        web = (WebView) findViewById(R.id.about_web);
        bar = (ProgressBar) findViewById(R.id.about_web_pro);
        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);
        web.setDrawingCacheEnabled(true);
        MyWebClient mClient = new MyWebClient();
        web.setWebViewClient(mClient);
        web.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    bar.setVisibility(View.INVISIBLE);
                } else {
                    if (View.INVISIBLE == bar.getVisibility()) {
                        bar.setVisibility(View.VISIBLE);
                    }
                    bar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

        });

    }

    private class MyWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isNet) {
            web.loadUrl(getString(R.string.www));
        } else {
            web.setVisibility(View.GONE);
        }
    }

}

