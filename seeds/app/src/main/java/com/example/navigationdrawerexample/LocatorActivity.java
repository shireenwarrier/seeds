package com.example.navigationdrawerexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class LocatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locator);
        if(MainActivity.MESSAGE.equals("mentoring")){setContentView(R.layout.activity_mentor);}
        else if(MainActivity.MESSAGE.equals("calendar")){setContentView(R.layout.activity_calendar);}
        else if(MainActivity.MESSAGE.equals("locator")){setContentView(R.layout.activity_locator);}
        else if(HomeActivity.MESSAGE.equals("mentoring")){setContentView(R.layout.activity_mentor);}
        else if(HomeActivity.MESSAGE.equals("calendar")){setContentView(R.layout.activity_calendar);}
        else if(HomeActivity.MESSAGE.equals("locator")){setContentView(R.layout.activity_locator);}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_locator, menu);
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
}
