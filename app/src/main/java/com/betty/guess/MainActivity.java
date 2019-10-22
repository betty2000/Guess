package com.betty.guess;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private TextView ednumber;
int counter;
int secret = new Random().nextInt(10) + 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ednumber  = findViewById(R.id.fab);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             int n = Integer.parseInt((ednumber.getText().toString()));
             ednumber.setText((Integer.toString(n)));

              if(n>secret){
                  Toast.makeText(MainActivity.this,"smaller", Toast.LENGTH_LONG).show();
             }else if (n<secret){
                    Toast.makeText(MainActivity.this,"bigger", Toast.LENGTH_LONG).show();
             }if (n==secret){
                    Toast.makeText(MainActivity.this, "congratulations", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
public void reset(View view ){
        counter=0;
        ednumber.setText(String.valueOf(counter));
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
