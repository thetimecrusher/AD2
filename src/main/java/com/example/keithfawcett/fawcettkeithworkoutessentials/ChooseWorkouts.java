package com.example.keithfawcett.fawcettkeithworkoutessentials;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ChooseWorkouts extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_workout_main);

        Context mContext = this;

        setTitle("Custom Workout");


        ListView listView = (ListView) findViewById(R.id.listView);
        ProgressBar progressSpinner = (ProgressBar) findViewById(R.id.progressBar);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar3);
        progressBar.setMax(5);


        if(CustomWorkoutFragment.loaded){

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                    mContext,
                    android.R.layout.simple_list_item_1,
                    CustomWorkoutFragment.myArray
            );
            progressSpinner.setVisibility(View.INVISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
            listView.setAdapter(arrayAdapter);
        }else {
            Toast.makeText(mContext, "Not loaded yet", Toast.LENGTH_SHORT).show();
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", CustomWorkoutFragment.myArray.get(i));
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }


        });

    }





}
