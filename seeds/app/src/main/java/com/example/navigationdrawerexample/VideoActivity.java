package com.example.navigationdrawerexample;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class VideoActivity extends Activity {

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        getActionBar().setTitle("Video");
        if(HomeActivity.MESSAGE.equals("video")){setContentView(R.layout.activity_video);}
        myWebView = (WebView) (findViewById(R.id.webView4));
        WebSettings ws = myWebView.getSettings();
        ws.setJavaScriptEnabled(true);

    }

    @Override
    public void onResume() {
        super.onResume();
        String url = getIntent().getStringExtra("url");
        myWebView.loadUrl(url);
        WebView myWebView = (WebView) findViewById(R.id.webView4);
        myWebView.setWebViewClient(new MyWebViewClient());
    }

    public boolean canMoveInside(int num, KeyEvent event) {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        } else {
            return super.onKeyDown(num, event);
        }
    }

    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            myWebView.setWebChromeClient(new WebChromeClient());
            if (Uri.parse(url).getHost().equals("https://youtu.be/zndy7aCQyUo")) {
                return false;
            }

            return false;

        }

    }
}
