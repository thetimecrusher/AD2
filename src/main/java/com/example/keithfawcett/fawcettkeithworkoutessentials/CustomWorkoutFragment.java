package com.example.keithfawcett.fawcettkeithworkoutessentials;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomWorkoutFragment extends android.support.v4.app.Fragment {

    private static final int CUSTOM_WORKOUT_REQUEST_CODE = 10111;
    private static final String ACTION_SAVE_DATA = "com.example.keithfawcett.fawcettkeithworkoutessentials.ACTION_SAVE_DATA";


    public static ArrayList<String> myArray = new ArrayList<>();

    public static Boolean loaded = false;


    private int reps1value = 1;
    private int reps2value = 1;
    private int reps3value = 1;
    private int reps4value = 1;
    private int reps5value = 1;

    private int sets1value = 1;
    private int sets2value = 1;
    private int sets3value = 1;
    private int sets4value = 1;
    private int sets5value = 1;

    private LinearLayout line1;
    private LinearLayout line2;
    private LinearLayout line3;
    private LinearLayout line4;
    private LinearLayout line5;

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

        getActivity().setTitle("Custom Workout");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_workout_main, container, false);


        setHasOptionsMenu(true);

        line1 = (LinearLayout) view.findViewById(R.id.roulette_line1);
        line2 = (LinearLayout) view.findViewById(R.id.roulette_line2);
        line3 = (LinearLayout) view.findViewById(R.id.roulette_line3);
        line4 = (LinearLayout) view.findViewById(R.id.roulette_line4);
        line5 = (LinearLayout) view.findViewById(R.id.roulette_line5);

        line1.setVisibility(View.INVISIBLE);
        line2.setVisibility(View.INVISIBLE);
        line3.setVisibility(View.INVISIBLE);
        line4.setVisibility(View.INVISIBLE);
        line5.setVisibility(View.INVISIBLE);

        exercise1 = (TextView) view.findViewById(R.id.tv_custom_exercise1);
        exercise2 = (TextView) view.findViewById(R.id.tv_custom_exercise2);
        exercise3 = (TextView) view.findViewById(R.id.tv_custom_exercise3);
        exercise4 = (TextView) view.findViewById(R.id.tv_custom_exercise4);
        exercise5 = (TextView) view.findViewById(R.id.tv_custom_exercise5);

        sets1 = (TextView) view.findViewById(R.id.tv_custom_sets1);
        sets2 = (TextView) view.findViewById(R.id.tv_custom_sets2);
        sets3 = (TextView) view.findViewById(R.id.tv_custom_sets3);
        sets4 = (TextView) view.findViewById(R.id.tv_custom_sets4);
        sets5 = (TextView) view.findViewById(R.id.tv_custom_sets5);

        reps1 = (TextView) view.findViewById(R.id.tv_custom_reps1);
        reps2 = (TextView) view.findViewById(R.id.tv_custom_reps2);
        reps3 = (TextView) view.findViewById(R.id.tv_custom_reps3);
        reps4 = (TextView) view.findViewById(R.id.tv_custom_reps4);
        reps5 = (TextView) view.findViewById(R.id.tv_custom_reps5);

        Button addReps1 = (Button) view.findViewById(R.id.reps_add_1);
        Button addReps2 = (Button) view.findViewById(R.id.reps_add_2);
        Button addReps3 = (Button) view.findViewById(R.id.reps_add_3);
        Button addReps4 = (Button) view.findViewById(R.id.reps_add_4);
        Button addReps5 = (Button) view.findViewById(R.id.reps_add_5);

        Button addSets1 = (Button) view.findViewById(R.id.sets_add_1);
        Button addSets2 = (Button) view.findViewById(R.id.sets_add_2);
        Button addSets3 = (Button) view.findViewById(R.id.sets_add_3);
        Button addSets4 = (Button) view.findViewById(R.id.sets_add_4);
        Button addSets5 = (Button) view.findViewById(R.id.sets_add_5);

        Button subtractReps1 = (Button) view.findViewById(R.id.reps_subtract_1);
        Button subtractReps2 = (Button) view.findViewById(R.id.reps_subtract_2);
        Button subtractReps3 = (Button) view.findViewById(R.id.reps_subtract_3);
        Button subtractReps4 = (Button) view.findViewById(R.id.reps_subtract_4);
        Button subtractReps5 = (Button) view.findViewById(R.id.reps_subtract_5);

        Button subtractSets1 = (Button) view.findViewById(R.id.sets_subtract_1);
        Button subtractSets2 = (Button) view.findViewById(R.id.sets_subtract_2);
        Button subtractSets3 = (Button) view.findViewById(R.id.sets_subtract_3);
        Button subtractSets4 = (Button) view.findViewById(R.id.sets_subtract_4);
        Button subtractSets5 = (Button) view.findViewById(R.id.sets_subtract_5);



        subtractReps1.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (reps1value != 1) {
                    reps1value -= 1;
                    reps1.setText(Integer.toString(reps1value) + " reps");
                }
            }
        });

        addReps1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reps1value += 1;
                reps1.setText(Integer.toString(reps1value) + " reps");
            }
        });

        subtractSets1.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sets1value != 1) {
                    sets1value -= 1;
                    sets1.setText(Integer.toString(sets1value) + " sets");
                }
            }
        });

        addSets1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sets1value += 1;
                sets1.setText(Integer.toString(sets1value) + " sets");
            }
        });

        subtractReps2.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (reps2value != 1) {
                    reps2value -= 1;
                    reps2.setText(Integer.toString(reps2value) + " reps");
                }
            }
        });

        addReps2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reps2value += 1;
                reps2.setText(Integer.toString(reps2value) + " reps");
            }
        });

        subtractSets2.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sets2value != 1) {
                    sets2value -= 1;
                    sets2.setText(Integer.toString(sets2value) + " sets");
                }
            }
        });

        addSets2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sets2value += 1;
                sets2.setText(Integer.toString(sets2value) + " sets");
            }
        });

        subtractReps3.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (reps3value != 1) {
                    reps3value -= 1;
                    reps3.setText(Integer.toString(reps3value) + " reps");
                }
            }
        });

        addReps3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reps3value += 1;
                reps3.setText(Integer.toString(reps3value) + " reps");
            }
        });

        subtractSets3.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sets3value != 1) {
                    sets3value -= 1;
                    sets3.setText(Integer.toString(sets3value) + " sets");
                }
            }
        });

        addSets3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sets3value += 1;
                sets3.setText(Integer.toString(sets3value) + " sets");
            }
        });

        subtractReps4.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (reps4value != 1) {
                    reps4value -= 1;
                    reps4.setText(Integer.toString(reps4value) + " reps");
                }
            }
        });

        addReps4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reps4value += 1;
                reps4.setText(Integer.toString(reps4value) + " reps");
            }
        });

        subtractSets4.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sets4value != 1) {
                    sets4value -= 1;
                    sets4.setText(Integer.toString(sets4value) + " sets");
                }
            }
        });

        addSets4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sets4value += 1;
                sets4.setText(Integer.toString(sets4value) + " sets");
            }
        });

        subtractReps5.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (reps5value != 1) {
                    reps5value -= 1;
                    reps5.setText(Integer.toString(reps5value) + " reps");
                }
            }
        });

        addReps5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reps5value += 1;
                reps5.setText(Integer.toString(reps5value) + " reps");
            }
        });

        subtractSets5.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sets5value != 1) {
                    sets5value -= 1;
                    sets5.setText(Integer.toString(sets5value) + " sets");
                }
            }
        });

        addSets5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sets5value += 1;
                sets5.setText(Integer.toString(sets5value) + " sets");
            }
        });


        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.fab);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getBaseContext(), ChooseWorkouts.class);

                startActivityForResult(intent, CUSTOM_WORKOUT_REQUEST_CODE);
            }
        });


                return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.custom_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.save){

            Intent saveIntent = new Intent(ACTION_SAVE_DATA);

            if(line1.getVisibility() == View.VISIBLE) {
                saveIntent.putExtra(MainActivity.EXTRA_EXERCISE1, exercise1.getText().toString());
                saveIntent.putExtra(MainActivity.EXTRA_REPS1, reps1value);
                saveIntent.putExtra(MainActivity.EXTRA_SETS1, sets1value);


                if (line2.getVisibility() == View.VISIBLE) {
                    saveIntent.putExtra(MainActivity.EXTRA_EXERCISE2, exercise2.getText().toString());
                    saveIntent.putExtra(MainActivity.EXTRA_REPS2, reps2value);
                    saveIntent.putExtra(MainActivity.EXTRA_SETS2, sets2value);

                    if (line3.getVisibility() == View.VISIBLE) {
                        saveIntent.putExtra(MainActivity.EXTRA_EXERCISE3, exercise3.getText().toString());
                        saveIntent.putExtra(MainActivity.EXTRA_REPS3, reps3value);
                        saveIntent.putExtra(MainActivity.EXTRA_SETS3, sets3value);

                        if (line4.getVisibility() == View.VISIBLE) {
                            saveIntent.putExtra(MainActivity.EXTRA_EXERCISE4, exercise4.getText().toString());
                            saveIntent.putExtra(MainActivity.EXTRA_REPS4, reps4value);
                            saveIntent.putExtra(MainActivity.EXTRA_SETS4, sets4value);

                            if (line5.getVisibility() == View.VISIBLE) {
                                saveIntent.putExtra(MainActivity.EXTRA_EXERCISE5, exercise5.getText().toString());
                                saveIntent.putExtra(MainActivity.EXTRA_REPS5, reps5value);
                                saveIntent.putExtra(MainActivity.EXTRA_SETS5, sets5value);
                            }
                        }
                    }
                }
                getContext().sendBroadcast(saveIntent);
            }else {
                Toast.makeText(getContext(), "Nothing to save", Toast.LENGTH_SHORT).show();
            }


            return true;
        }else if (id == R.id.clear){
            line1.setVisibility(View.INVISIBLE);
            line2.setVisibility(View.INVISIBLE);
            line3.setVisibility(View.INVISIBLE);
            line4.setVisibility(View.INVISIBLE);
            line5.setVisibility(View.INVISIBLE);
        }
        return super.onOptionsItemSelected(item);
    }
    

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == CUSTOM_WORKOUT_REQUEST_CODE) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");


                if(line4.getVisibility() == View.VISIBLE){
                    line5.setVisibility(View.VISIBLE);
                    exercise5.setText(result);
                }else if(line3.getVisibility() == View.VISIBLE) {
                    line4.setVisibility(View.VISIBLE);
                    exercise4.setText(result);
                }else if(line2.getVisibility() == View.VISIBLE) {
                    line3.setVisibility(View.VISIBLE);
                    exercise3.setText(result);
                }else if(line1.getVisibility() == View.VISIBLE) {
                    line2.setVisibility(View.VISIBLE);
                    exercise2.setText(result);
                }else {
                    line1.setVisibility(View.VISIBLE);
                    exercise1.setText(result);
                }
                Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.d("CustomWorkoutFragment", "onActivityResult: Canceled");
                //Write your code if there's no result
            }
        }
    }//onActivityResult
}
