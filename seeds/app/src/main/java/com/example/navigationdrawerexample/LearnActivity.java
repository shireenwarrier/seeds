package com.example.navigationdrawerexample;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;


public class LearnActivity extends Activity {

    private ExpandListAdapter ExpAdapter;
    private ArrayList<Group> ExpListItems;
    private ExpandableListView ExpandList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        getActionBar().setTitle("Learn");
        super.onCreate(savedInstanceState);
        if(HomeActivity.MESSAGE.equals("java")){setContentView(R.layout.java_layout);}
        else if(HomeActivity.MESSAGE.equals("python")){setContentView(R.layout.python_layout);}
        else if(MainActivity.MESSAGE.equals("java")){setContentView(R.layout.java_layout);}
        else if(MainActivity.MESSAGE.equals("python")){setContentView(R.layout.python_layout);}

        ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
        ExpListItems = SetStandardGroups();
        ExpAdapter = new ExpandListAdapter(LearnActivity.this, ExpListItems);
        ExpandList.setAdapter(ExpAdapter);

    }


    public ArrayList<Group> SetStandardGroups() {

        String group_names[] = { "Hello World!", "Ints and Doubles", "Math Operations", "Strings",
                "Variables"};

        int Images[] = {R.drawable.stringsjava5,
                R.drawable.stringsjava5, R.drawable.stringsjava5, R.drawable.stringsjava5, R.drawable.stringsjava5,};

        ArrayList<Group> list = new ArrayList<Group>();

        ArrayList<Child> ch_list;

        int size = 1;
        int j = 0;

        for (String group_name : group_names) {
            Group gru = new Group();
            gru.setName(group_name);

            ch_list = new ArrayList<Child>();


            for (; j < size; j++) {
                Child ch = new Child();
                ch.setImage(Images[j]);
                ch_list.add(ch);
            }
            gru.setItems(ch_list);
            list.add(gru);

            size = size + 1;
        }

        return list;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn, menu);
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
