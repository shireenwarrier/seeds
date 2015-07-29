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

import java.net.URI;


public class CalendarActivity extends Activity {
    WebView myWebView;
    public static String MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setTitle("Calendar");
        setContentView(R.layout.activity_calendar);
        if(MainActivity.MESSAGE.equals("mentoring")){setContentView(R.layout.activity_mentor);}
        else if(MainActivity.MESSAGE.equals("calendar")){setContentView(R.layout.activity_calendar);}
        else if(MainActivity.MESSAGE.equals("locator")){setContentView(R.layout.activity_locator);}
        else if(MainActivity.MESSAGE.equals("forum")){setContentView(R.layout.activity_forum);}
        else if(HomeActivity.MESSAGE.equals("mentoring")){setContentView(R.layout.activity_mentor);}
        else if(HomeActivity.MESSAGE.equals("calendar")){setContentView(R.layout.activity_calendar);}
        else if(HomeActivity.MESSAGE.equals("locator")){setContentView(R.layout.activity_locator);}
        else if(HomeActivity.MESSAGE.equals("forum")){setContentView(R.layout.activity_forum);}
        myWebView = (WebView)(findViewById(R.id.webView));
        WebSettings ws = myWebView.getSettings();
        ws.setJavaScriptEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calendar, menu);
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
        WebView myWebView = (WebView)findViewById(R.id.webView);
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
            if (Uri.parse(url).getHost().equals("https://www.google.com/calendar/embed?src=vdudc68j102b36b47n8mirg33c%40group.calendar.google.com&ctz=America/Los_Angeles")){
                return false;
            }
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
            return true;
        }
    }

    //to move to webview with the google form for adding an event
    public void addEvent(View view) {
        Intent event = new Intent(this, AddEventActivity.class);
        event.putExtra("url","http://goo.gl/forms/4QecbLtilN");
        switch (view.getId()) {
            case R.id.imageButton100:
                MESSAGE = "addevent";
                break;

        }
        startActivity(event);
    }
}
