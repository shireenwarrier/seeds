package com.example.navigationdrawerexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MentorActivity extends Activity {

    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mentor);
        if(MainActivity.MESSAGE.equals("mentoring")){setContentView(R.layout.activity_mentor);}
        else if(MainActivity.MESSAGE.equals("calendar")){setContentView(R.layout.activity_calendar);}
        else if(MainActivity.MESSAGE.equals("locator")){setContentView(R.layout.activity_locator);}
        else if(HomeActivity.MESSAGE.equals("mentoring")){setContentView(R.layout.activity_mentor);}
        else if(HomeActivity.MESSAGE.equals("calendar")){setContentView(R.layout.activity_calendar);}
        else if(HomeActivity.MESSAGE.equals("locator")){setContentView(R.layout.activity_locator);}
        myWebView = (WebView)(findViewById(R.id.webView2));
        WebSettings ws = myWebView.getSettings();
        ws.setJavaScriptEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_continued_connect, menu);
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
    public void onResume(){
        super.onResume();
        String url = getIntent().getStringExtra("url");
        myWebView.loadUrl(url);
        WebView myWebView = (WebView)findViewById(R.id.webView2);
        myWebView.setWebViewClient(new MyWebViewClient());
    }

    public boolean canMoveInside(int num, KeyEvent event) {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
            return true;
        }
        else {
            return super.onKeyDown(num, event);
        }
    }

    private class MyWebViewClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            if (Uri.parse(url).getHost().equals("https://docs.google.com/forms/d/1IjfXRGAFEoskViuCaDeX8AbPVYti_JMhhblE7k2UcT4/viewform?c=0&w=1")){
                return false;
            }
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
            return true;
        }
    }

}
