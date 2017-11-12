package com.example.androidtask;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;
import static android.R.id.switch_widget;
import static com.example.androidtask.R.id.default_activity_button;
import static com.example.androidtask.R.id.list_view;
import static com.example.androidtask.R.id.submenuarrow;

public class ListActivity extends AppCompatActivity {

    private int count = 1;
    private ArrayList<String> issue = new ArrayList<>();
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todolist_layout);
        ListView listView = (ListView) findViewById(R.id.list_view);
        adapter = new ArrayAdapter(ListActivity.this, android.R.layout.simple_list_item_1, issue);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode) {
            case 1:
                if(resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("input_text");
                    adapter.add(returnData);
                    adapter.notifyDataSetChanged();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item :
                Intent intent = new Intent(ListActivity.this, AddActivity.class);
                startActivityForResult(intent, 1);
                break;
            default:
                break;
        }
        return true;
    }
}