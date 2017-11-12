package com.example.androidtask;

import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.List;

public class AddActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_layout);
        editText = (EditText) findViewById(R.id.edit_text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.done_item :
                String inputText = editText.getText().toString();
                Intent intent = new Intent(AddActivity.this, ListActivity.class);
                intent.putExtra("input_text", inputText);
                setResult(RESULT_OK, intent);
                finish();
            default:
                break;
        }
        return true;
    }
}
