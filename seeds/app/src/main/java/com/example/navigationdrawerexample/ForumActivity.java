package com.example.navigationdrawerexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ExpandableListView;

import java.util.ArrayList;


public class ForumActivity extends Activity {
    private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;
    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getActionBar().setTitle("Forum");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);
        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        //ExpListItems = makeTopics();
        ExpAdapter = new ExpandListAdapter(ForumActivity.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

    }

    public void onClick(){
        Intent intent = new Intent(ForumActivity.this,AddTopic.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forum, menu);
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
    public void onResume(){
        super.onResume();
        String url = getIntent().getStringExtra("url");
        myWebView.loadUrl(url);
        WebView myWebView = (WebView)findViewById(R.id.webView3);
        myWebView.setWebViewClient(new MyWebViewClient());
    }
    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            if (Uri.parse(url).getHost().equals("https://docs.google.com/forms/d/1VmNH-HGRiBTx9OcF1Er40hSlONoTV4kPnW3-3mJN4Mo/viewform?usp=send_form")){
                return false;
            }
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
            return true;
        }
    }
}
