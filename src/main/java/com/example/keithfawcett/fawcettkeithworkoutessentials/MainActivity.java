package com.example.keithfawcett.fawcettkeithworkoutessentials;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.keithfawcett.fawcettkeithworkoutessentials.database.DataSource;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String EXTRA_EXERCISE1 = "com.example.keithfawcett.fawcettkeithworkoutessentials.EXERCISE1";
    public static final String EXTRA_REPS1 = "com.example.keithfawcett.fawcettkeithworkoutessentials.REPS1";
    public static final String EXTRA_SETS1 = "com.example.keithfawcett.fawcettkeithworkoutessentials.SETS1";
    public static final String EXTRA_EXERCISE2 = "com.example.keithfawcett.fawcettkeithworkoutessentials.EXERCISE2";
    public static final String EXTRA_REPS2 = "com.example.keithfawcett.fawcettkeithworkoutessentials.REPS2";
    public static final String EXTRA_SETS2 = "com.example.keithfawcett.fawcettkeithworkoutessentials.SETS2";
    public static final String EXTRA_EXERCISE3 = "com.example.keithfawcett.fawcettkeithworkoutessentials.EXERCISE3";
    public static final String EXTRA_REPS3 = "com.example.keithfawcett.fawcettkeithworkoutessentials.REPS3";
    public static final String EXTRA_SETS3 = "com.example.keithfawcett.fawcettkeithworkoutessentials.SETS3";
    public static final String EXTRA_EXERCISE4 = "com.example.keithfawcett.fawcettkeithworkoutessentials.EXERCISE4";
    public static final String EXTRA_REPS4 = "com.example.keithfawcett.fawcettkeithworkoutessentials.REPS4";
    public static final String EXTRA_SETS4 = "com.example.keithfawcett.fawcettkeithworkoutessentials.SETS4";
    public static final String EXTRA_EXERCISE5 = "com.example.keithfawcett.fawcettkeithworkoutessentials.EXERCISE5";
    public static final String EXTRA_REPS5 = "com.example.keithfawcett.fawcettkeithworkoutessentials.REPS5";
    public static final String EXTRA_SETS5 = "com.example.keithfawcett.fawcettkeithworkoutessentials.SETS5";

    public static final String ACTION_UPDATE_LIST = "com.example.keithfawcett.fawcettkeithworkoutessentials.ACTION_UPDATE_LIST";


    public static DataSource mDataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDataSource = new DataSource(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        displaySelectedScreen(R.id.nav_sound_mixer);

        getInfo();
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    private void displaySelectedScreen(int id){
        android.support.v4.app.Fragment fragment = null;



        switch(id){
            case R.id.nav_sound_mixer:
                fragment = new SoundMixerFragment();
                break;
            case R.id.nav_timers:
                fragment = new TimersFragment();
                break;
            case R.id.nav_workout_roulette:
                fragment = new WorkoutRouletteFragment();
                break;
            case R.id.nav_custom_workout:
                fragment = new CustomWorkoutFragment();
                break;
            case R.id.nav_workout_history:
                fragment = new WorkoutHistoryFragment();
                break;
        }

        if(fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_main, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        displaySelectedScreen(id);

        return true;
    }

    private void getInfo() {

        ConnectivityManager mgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if(mgr != null) {
            NetworkInfo info = mgr.getActiveNetworkInfo();
            if(info != null) {
                boolean isConnected = info.isConnected();

                if (isConnected) {
                    CustomWorkoutFragment.myArray = new ArrayList<>();

                    new DataTask(1).execute("https://wger.de/api/v2/exercise/?format=json&language=2&page=1");

                }
            }
        }

    }

    private String getNetworkData(String urlString){
        try {
            URL url = new URL(urlString);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.connect();

            InputStream is = connection.getInputStream();
            String data = IOUtils.toString(is);
            is.close();

            connection.disconnect();

            return data;

        } catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }




    // make AsyncTask
    private class DataTask extends AsyncTask<String, String, String> {
        private int count;

        DataTask(int count){
            this.count = count;
        }



        //run the getNetworkData in the background
        @Override
        protected String doInBackground(String... params) {

            return getNetworkData(params[0]);
        }

        // after pars the JSON data
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                JSONObject outerMostObject = new JSONObject(s);
                JSONArray results = outerMostObject.getJSONArray("results");


                for (int i = 0; i < results.length(); i++) {
                    JSONObject item = results.getJSONObject(i);

                    CustomWorkoutFragment.myArray.add(item.getString(("name")));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }


            if(count < 4){
                new DataTask(++count).execute("https://wger.de/api/v2/exercise/?format=json&language=2&page=" + count);
            }else{
                CustomWorkoutFragment.loaded = true;
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mDataSource.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mDataSource.open();
    }
}
