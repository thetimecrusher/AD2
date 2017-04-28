package com.example.keithfawcett.fawcettkeithworkoutessentials;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.keithfawcett.fawcettkeithworkoutessentials.model.Workout;

import java.util.ArrayList;
import java.util.Collections;


class HistoryAdapter extends BaseAdapter {

    private static final int ID_CONSTANT = 0x0101001;
    private final ArrayList<Workout> mCollection;
    private final Context mContext;

    public HistoryAdapter(ArrayList<Workout> mCollection, Context mContext) {
        this.mCollection = mCollection;
        Collections.reverse(mCollection);
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return WorkoutHistoryFragment.workouts.size();

    }

    @Override
    public Object getItem(int position) {
        if(mCollection != null && position >= 0 && position < mCollection.size()) {
            return WorkoutHistoryFragment.workouts.get(position);
        }else{
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        if(mCollection != null && position >= 0 && position < mCollection.size()) {
            return ID_CONSTANT + position;
        }else {
            return 0;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.history_row, viewGroup, false);
        }

        Workout workout = (Workout) getItem(position);

        TextView date = (TextView) convertView.findViewById(R.id.history_date);
        TextView workout1 = (TextView) convertView.findViewById(R.id.history_tv_exercise1);
        TextView reps1 = (TextView) convertView.findViewById(R.id.history_tv_reps1);
        TextView sets1 = (TextView) convertView.findViewById(R.id.history_tv_sets1);
        TextView workout2 = (TextView) convertView.findViewById(R.id.history_tv_exercise2);
        TextView reps2 = (TextView) convertView.findViewById(R.id.history_tv_reps2);
        TextView sets2 = (TextView) convertView.findViewById(R.id.history_tv_sets2);
        TextView workout3 = (TextView) convertView.findViewById(R.id.history_tv_exercise3);
        TextView reps3 = (TextView) convertView.findViewById(R.id.history_tv_reps3);
        TextView sets3 = (TextView) convertView.findViewById(R.id.history_tv_sets3);
        TextView workout4 = (TextView) convertView.findViewById(R.id.history_tv_exercise4);
        TextView reps4 = (TextView) convertView.findViewById(R.id.history_tv_reps4);
        TextView sets4 = (TextView) convertView.findViewById(R.id.history_tv_sets4);
        TextView workout5 = (TextView) convertView.findViewById(R.id.history_tv_exercise5);
        TextView reps5 = (TextView) convertView.findViewById(R.id.history_tv_reps5);
        TextView sets5 = (TextView) convertView.findViewById(R.id.history_tv_sets5);


        date.setText(workout.getWorkoutDate());

        workout1.setText(workout.getWorkoutExercise1());
        reps1.setText(Integer.toString(workout.getWorkoutReps1()));
        sets1.setText(Integer.toString(workout.getWorkoutSets1()));

        workout2.setText(workout.getWorkoutExercise2());
        reps2.setText(Integer.toString(workout.getWorkoutReps2()));
        sets2.setText(Integer.toString(workout.getWorkoutSets2()));

        workout3.setText(workout.getWorkoutExercise3());
        reps3.setText(Integer.toString(workout.getWorkoutReps3()));
        sets3.setText(Integer.toString(workout.getWorkoutSets3()));

        workout4.setText(workout.getWorkoutExercise4());
        reps4.setText(Integer.toString(workout.getWorkoutReps4()));
        sets4.setText(Integer.toString(workout.getWorkoutSets4()));

        workout5.setText(workout.getWorkoutExercise5());
        reps5.setText(Integer.toString(workout.getWorkoutReps5()));
        sets5.setText(Integer.toString(workout.getWorkoutSets5()));

        if(workout.getWorkoutExercise2() == null){
            reps2.setText(" ");
            sets2.setText(" ");
        }
        if(workout.getWorkoutExercise3() == null){
            reps3.setText(" ");
            sets3.setText(" ");
        }
        if(workout.getWorkoutExercise4() == null){
            reps4.setText(" ");
            sets4.setText(" ");
        }
        if(workout.getWorkoutExercise5() == null){
            reps5.setText(" ");
            sets5.setText(" ");
        }



        return convertView;
    }
}
