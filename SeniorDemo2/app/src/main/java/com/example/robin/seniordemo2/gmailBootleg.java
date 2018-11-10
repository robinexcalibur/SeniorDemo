package com.example.robin.seniordemo2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Scanner;

public class gmailBootleg extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private GmailListAdapter mAdapter;
    static String[] titleHolder;
    static String[] subHolder;
    static String[] bodyHolder;
    static String[] timeHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gmail_bootleg);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Context context = gmailBootleg.this;
                    Class startSelectedActivity = MapsActivity.class;
                    Intent startChildActivityIntent = new Intent(context, startSelectedActivity);

                    startActivity(startChildActivityIntent);
                }

        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //set up the recycler view:
        scanHardCodedValues(); //build the arrays
        RecyclerView menuRecyclerView;
        menuRecyclerView = (RecyclerView) this.findViewById(R.id.recyclerView);
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        mAdapter = new GmailListAdapter(this, titleHolder, subHolder, bodyHolder, timeHolder);
        menuRecyclerView.setAdapter(mAdapter);
        //--- end of recycler view stuff ---
    }

    private void scanHardCodedValues() {

        Log.d("debug", "in scanfile file");
        try {
            Scanner scan = new Scanner(getResources().openRawResource(R.raw.sample));


            //String holder = "";
            String word = scan.next();
            int counter = 0;
            String title = "";
            String sub = "";
            String body = "";
            String time = "";

            while (scan.hasNext()) {

                if (counter%4 == 0) {
                    title = title + " " + word;
                } else if (counter%4 == 1) {
                    sub = sub + " " + word;
                } else if (counter%4 == 2) {
                    body = body + " " + word;
                } else { // == 3
                    time = time + " " + word;
                }

                if (word.endsWith(",")) {
                    counter++;
                    Log.d("debug", "word " + title);
                }
                word = scan.next();
            }
            scan.close();

            String eliminate = "[,]";
            titleHolder = title.split(eliminate);
            subHolder = sub.split(eliminate);
            bodyHolder = body.split(eliminate);
            timeHolder = time.split(eliminate);


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gmail_bootleg, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
