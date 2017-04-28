package com.example.keithfawcett.fawcettkeithworkoutessentials;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class WorkoutRouletteFragment extends android.support.v4.app.Fragment {


    private static final String ACTION_SAVE_DATA = "com.example.keithfawcett.fawcettkeithworkoutessentials.ACTION_SAVE_DATA";

    private final Random r = new Random();


    private TextView exercise1;
    private TextView exercise2;
    private TextView exercise3;
    private TextView exercise4;
    private TextView exercise5;
    private TextView sets1;
    private TextView sets2;
    private TextView sets3;
    private TextView sets4;
    private TextView sets5;
    private TextView reps1;
    private TextView reps2;
    private TextView reps3;
    private TextView reps4;
    private TextView reps5;



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setHasOptionsMenu(true);

        getActivity().setTitle("Workout Roulette");

        sets1 = (TextView) view.findViewById(R.id.tv_sets1);
        sets2 = (TextView) view.findViewById(R.id.tv_sets2);
        sets3 = (TextView) view.findViewById(R.id.tv_sets3);
        sets4 = (TextView) view.findViewById(R.id.tv_sets4);
        sets5 = (TextView) view.findViewById(R.id.tv_sets5);
        reps1 = (TextView) view.findViewById(R.id.tv_reps1);
        reps2 = (TextView) view.findViewById(R.id.tv_reps2);
        reps3 = (TextView) view.findViewById(R.id.tv_reps3);
        reps4 = (TextView) view.findViewById(R.id.tv_reps4);
        reps5 = (TextView) view.findViewById(R.id.tv_reps5);
        exercise1 = (TextView) view.findViewById(R.id.tv_exercise1);
        exercise2 = (TextView) view.findViewById(R.id.tv_exercise2);
        exercise3 = (TextView) view.findViewById(R.id.tv_exercise3);
        exercise4 = (TextView) view.findViewById(R.id.tv_exercise4);
        exercise5 = (TextView) view.findViewById(R.id.tv_exercise5);

        if(CustomWorkoutFragment.loaded){
            spin();
        }else {
            Toast.makeText(getContext(), "Not loaded yet", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.roulette_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.spin) {
            if(CustomWorkoutFragment.loaded){
                spin();
            }else {
                Toast.makeText(getContext(), "Not loaded yet", Toast.LENGTH_SHORT).show();
            }
            return true;
        } else if(id == R.id.save){



            Intent saveIntent = new Intent(ACTION_SAVE_DATA);
            saveIntent.putExtra(MainActivity.EXTRA_EXERCISE1, exercise1.getText().toString());
            saveIntent.putExtra(MainActivity.EXTRA_REPS1, Integer.parseInt(reps1.getText().toString().split(" ")[0]));
            saveIntent.putExtra(MainActivity.EXTRA_SETS1, Integer.parseInt(sets1.getText().toString().split(" ")[0]));

            saveIntent.putExtra(MainActivity.EXTRA_EXERCISE2, exercise2.getText().toString());
            saveIntent.putExtra(MainActivity.EXTRA_REPS2, Integer.parseInt(reps2.getText().toString().split(" ")[0]));
            saveIntent.putExtra(MainActivity.EXTRA_SETS2, Integer.parseInt(sets2.getText().toString().split(" ")[0]));

            saveIntent.putExtra(MainActivity.EXTRA_EXERCISE3, exercise3.getText().toString());
            saveIntent.putExtra(MainActivity.EXTRA_REPS3, Integer.parseInt(reps3.getText().toString().split(" ")[0]));
            saveIntent.putExtra(MainActivity.EXTRA_SETS3, Integer.parseInt(sets3.getText().toString().split(" ")[0]));

            saveIntent.putExtra(MainActivity.EXTRA_EXERCISE4, exercise4.getText().toString());
            saveIntent.putExtra(MainActivity.EXTRA_REPS4, Integer.parseInt(reps4.getText().toString().split(" ")[0]));
            saveIntent.putExtra(MainActivity.EXTRA_SETS4, Integer.parseInt(sets4.getText().toString().split(" ")[0]));

            saveIntent.putExtra(MainActivity.EXTRA_EXERCISE5, exercise5.getText().toString());
            saveIntent.putExtra(MainActivity.EXTRA_REPS5, Integer.parseInt(reps5.getText().toString().split(" ")[0]));
            saveIntent.putExtra(MainActivity.EXTRA_SETS5, Integer.parseInt(sets5.getText().toString().split(" ")[0]));


            getContext().sendBroadcast(saveIntent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.workout_roulette_main, container, false);
    }

    

private void spin(){
    for (int i = 1; i < 6; i++) {
        int randomReps = r.nextInt(35) + 5;
        int randomSets = r.nextInt(10) + 1;
        int randomWorkout = r.nextInt(CustomWorkoutFragment.myArray.size()-4)+4;

        if(i == 1){
            exercise1.setText(CustomWorkoutFragment.myArray.get(randomWorkout));
            sets1.setText(randomSets+ " sets");
            reps1.setText(randomReps+ " reps");
        }else if(i ==2){
            exercise2.setText(CustomWorkoutFragment.myArray.get(randomWorkout));
            sets2.setText(randomSets+ " sets");
            reps2.setText(randomReps+ " reps");
        }else if(i ==3){
            exercise3.setText(CustomWorkoutFragment.myArray.get(randomWorkout));
            sets3.setText(randomSets+ " sets");
            reps3.setText(randomReps+ " reps");
        }else if(i ==4){
            exercise4.setText(CustomWorkoutFragment.myArray.get(randomWorkout));
            sets4.setText(randomSets+ " sets");
            reps4.setText(randomReps+ " reps");
        }else if(i ==5){
            exercise5.setText(CustomWorkoutFragment.myArray.get(randomWorkout));
            sets5.setText(randomSets+ " sets");
            reps5.setText(randomReps+ " reps");
        }
    }

}


}
