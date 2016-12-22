package com.example.hadi.dynamic;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button b1 = (Button)findViewById(R.id.btn_anon1);
        Button b2 = (Button)findViewById(R.id.btn_anon2);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // function for btn anon 1
                Log.i("info","Anonymous Button 1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // function for btn anon 2
                Log.i("info","Anonymous Button 2");
            }
        });

        Button b3 = (Button)findViewById(R.id.btn_inner1);
        b3.setOnClickListener(new ClickHandler("Inner 1"));
        Button b4 = (Button)findViewById(R.id.btn_inner2);
        b4.setOnClickListener(new ClickHandler("Inner 2"));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
                Button btn = new Button(MainActivity.this);
                ViewGroup vg = (ViewGroup)findViewById(R.id.content_main);
                vg.addView(btn);
                btn.setText("Button no " + vg.getChildCount());
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //        .setAction("Action", null).show();
                        Button btn = new Button(MainActivity.this);
                        ViewGroup vg = (ViewGroup) findViewById(R.id.content_main);
                        vg.addView(btn);
                    }
                });

            }
        });
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

    class ClickHandler implements View.OnClickListener {
        String name;
        ClickHandler(String name) {
            this.name = name;
        }
        @Override
        public void onClick(View v) {
            Log.i("info","Button inner class " + name);
        }
    }
}