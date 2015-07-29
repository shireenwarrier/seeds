package com.example.navigationdrawerexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class HomeActivity extends Activity {

    public static String MESSAGE = "connect";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        if(MainActivity.MESSAGE.equals("play")){setContentView(R.layout.activity_play); getActionBar().setTitle("Play");}
        else if(MainActivity.MESSAGE.equals("learn")){setContentView(R.layout.activity_learn);getActionBar().setTitle("Learn");}
        else if(MainActivity.MESSAGE.equals("connect")){setContentView(R.layout.activity_connect);getActionBar().setTitle("Connect");}
        else if(MainActivity.MESSAGE.equals("video")){setContentView(R.layout.activity_video); getActionBar().setTitle("Video");}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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

    public void pressMentorButton(View view) {
        Intent mentoring = new Intent(this, MentorActivity.class);
        mentoring.putExtra("url","https://docs.google.com/forms/d/1IjfXRGAFEoskViuCaDeX8AbPVYti_JMhhblE7k2UcT4/viewform?c=0&w=1");
        switch (view.getId()) {
            case R.id.locator:
                MESSAGE = "locator";
                break;
            case R.id.mentoring:
                MESSAGE = "mentoring";
                break;
            case R.id.calendar:
                MESSAGE = "calendar";
                break;
            case R.id.forum:
                MESSAGE = "forum";
                break;
        }
        startActivity(mentoring);
    }

    public void pressCalendarButton(View view) {
        Intent calendar = new Intent(this, CalendarActivity.class);
        calendar.putExtra("url","https://www.google.com/calendar/embed?src=vdudc68j102b36b47n8mirg33c%40group.calendar.google.com&ctz=America/Los_Angeles");
        switch (view.getId()) {
            case R.id.locator:
                MESSAGE = "locator";
                break;
            case R.id.mentoring:
                MESSAGE = "mentoring";
                break;
            case R.id.calendar:
                MESSAGE = "calendar";
                break;
            case R.id.forum:
                MESSAGE = "forum";
                break;
        }
        startActivity(calendar);
    }

    public void pressLocatorButton(View view) {
        Intent locator = new Intent(this, LocatorActivity.class);
        switch (view.getId()) {
            case R.id.locator:
                MESSAGE = "locator";
                break;
            case R.id.mentoring:
                MESSAGE = "mentoring";
                break;
            case R.id.calendar:
                MESSAGE = "calendar";
                break;
            case R.id.forum:
                MESSAGE = "forum";
                break;
        }
        startActivity(locator);
    }

    public void pressLearnButton(View view) {
        Intent intent = new Intent(this, LearnActivity.class);
        switch (view.getId()) {
            case R.id.javaButton:
                MESSAGE = "java";
                break;
            case R.id.pythonButton:
                MESSAGE = "python";
                break;
        }
        startActivity(intent);
    }

    public void pressForumButton(View view){
        Intent intent = new Intent(this, ForumActivity.class);
        intent.putExtra("url","https://docs.google.com/forms/d/1VmNH-HGRiBTx9OcF1Er40hSlONoTV4kPnW3-3mJN4Mo/viewform?usp=send_form");
        switch (view.getId()) {
            case R.id.locator:
                MESSAGE = "locator";
                break;
            case R.id.mentoring:
                MESSAGE = "mentoring";
                break;
            case R.id.calendar:
                MESSAGE = "calendar";
                break;
            case R.id.forum:
                MESSAGE = "forum";
                break;
        }
        startActivity(intent);
    }

}
