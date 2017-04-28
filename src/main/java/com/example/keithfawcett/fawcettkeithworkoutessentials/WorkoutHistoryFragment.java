package com.example.keithfawcett.fawcettkeithworkoutessentials;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.keithfawcett.fawcettkeithworkoutessentials.model.Workout;

import java.util.ArrayList;
import java.util.List;


public class WorkoutHistoryFragment extends android.support.v4.app.Fragment {


    public static final ArrayList<Workout> workouts = new ArrayList<>();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Workout> loadArray = MainActivity.mDataSource.getAllItems();


        workouts.clear();
        for(int i = 0; i < loadArray.size(); i++){
            workouts.add(loadArray.get(i));
        }

        ListView listView = (ListView) view.findViewById(R.id.history_listView);

        HistoryAdapter historyAdapter = new HistoryAdapter(workouts, getContext());


        listView.setAdapter(historyAdapter);




    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.workout_history_main, container, false);
    }


}
