package com.example.robin.seniordemo2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This will send us to the next activity, specifically gmailBootleg
    public void toSelectPage(View view) {
        Context context = MainActivity.this;
        Class startSelectedActivity = gmailBootleg.class;
        Intent startChildActivityIntent = new Intent(context, startSelectedActivity);

        startActivity(startChildActivityIntent);
    }
}
