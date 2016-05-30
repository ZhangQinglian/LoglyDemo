package com.zqlite.android.lollydemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.zqlite.android.logly.Logly;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Logly logly = Logly.own();
        logly.setGlobalTag(new Logly.Tag( Logly.FLAG_THREAD_NAME,"scott",Logly.DEBUG));
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                logly.d(new Logly.Tag(Logly.FLAG_NONE,"ssssss",Logly.DEBUG),"  cus");
                logly.v("    v");
                logly.i("    i");
                logly.d("    d");
                logly.w("    w");
                logly.e("    e");
                handler.postDelayed(this,1000);
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
}
