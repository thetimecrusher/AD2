

package com.example.keithfawcett.fawcettkeithworkoutessentials.database;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.keithfawcett.fawcettkeithworkoutessentials.MainActivity;
import com.example.keithfawcett.fawcettkeithworkoutessentials.model.Workout;

import java.util.Calendar;

public class SaveReceiver extends BroadcastReceiver {


    private final Calendar calendar = Calendar.getInstance();

    @Override
    public void onReceive(Context context, Intent intent) {

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) +1;
        int year = calendar.get(Calendar.YEAR);

        String date = month + "/" + day + "/" + year;

        String exercise1 = intent.getStringExtra(MainActivity.EXTRA_EXERCISE1);
        int reps1 = intent.getIntExtra(MainActivity.EXTRA_REPS1, 0);
        int sets1 = intent.getIntExtra(MainActivity.EXTRA_SETS1, 0);
        String exercise2 = intent.getStringExtra(MainActivity.EXTRA_EXERCISE2);
        int reps2 = intent.getIntExtra(MainActivity.EXTRA_REPS2, 0);
        int sets2 = intent.getIntExtra(MainActivity.EXTRA_SETS2, 0);
        String exercise3 = intent.getStringExtra(MainActivity.EXTRA_EXERCISE3);
        int reps3 = intent.getIntExtra(MainActivity.EXTRA_REPS3, 0);
        int sets3 = intent.getIntExtra(MainActivity.EXTRA_SETS3, 0);
        String exercise4 = intent.getStringExtra(MainActivity.EXTRA_EXERCISE4);
        int reps4 = intent.getIntExtra(MainActivity.EXTRA_REPS4, 0);
        int sets4 = intent.getIntExtra(MainActivity.EXTRA_SETS4, 0);
        String exercise5 = intent.getStringExtra(MainActivity.EXTRA_EXERCISE5);
        int reps5 = intent.getIntExtra(MainActivity.EXTRA_REPS5, 0);
        int sets5 = intent.getIntExtra(MainActivity.EXTRA_SETS5, 0);
        Toast.makeText(context, "Workout Saved", Toast.LENGTH_SHORT ).show();

        Workout newWorkout = new Workout(null, date, exercise1, reps1, sets1, exercise2, reps2, sets2, exercise3, reps3, sets3,
                exercise4, reps4, sets4, exercise5, reps5, sets5);
        DataSource mDataSource = new DataSource(context);
        mDataSource.open();
        mDataSource.addWorkout(newWorkout);


        Intent updateIntent = new Intent(MainActivity.ACTION_UPDATE_LIST);

        context.sendBroadcast(updateIntent);


    }

}
