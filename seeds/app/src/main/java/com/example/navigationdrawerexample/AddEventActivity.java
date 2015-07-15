package com.example.navigationdrawerexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class AddEventActivity extends Activity {
    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setTitle("Add an Event");
        setContentView(R.layout.activity_add_event);
        if (CalendarActivity.MESSAGE.equals("addevent")) {
            setContentView(R.layout.activity_add_event);
        }
        myWebView = (WebView) (findViewById(R.id.webView5));
        WebSettings ws = myWebView.getSettings();
        ws.setJavaScriptEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        String url = getIntent().getStringExtra("url");
        myWebView.loadUrl(url);
        WebView myWebView = (WebView) findViewById(R.id.webView5);
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
            if (Uri.parse(url).getHost().equals("http://goo.gl/forms/4QecbLtilN")) {
                view.loadUrl(url);
                return false;
            }

//            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//            startActivity(i);
            return false;
        }
    }


}