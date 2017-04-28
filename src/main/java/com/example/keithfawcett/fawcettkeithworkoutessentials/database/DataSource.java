

package com.example.keithfawcett.fawcettkeithworkoutessentials.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.keithfawcett.fawcettkeithworkoutessentials.model.Workout;

import java.util.ArrayList;
import java.util.List;

public class DataSource {


    private SQLiteDatabase mDatabase;
    private final SQLiteOpenHelper mDbHelper;

    public DataSource(Context context) {
        mDbHelper = new DBHelper(context);
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void open() {
        mDatabase = mDbHelper.getWritableDatabase();

    }

    public void close() {
        mDbHelper.close();

    }

    public void addWorkout(Workout workout){
        ContentValues values = workout.toValues();
        mDatabase.insert(HistoryTable.TABLE_HISTORY, null, values);
    }



    public List<Workout> getAllItems(){
        List<Workout> workoutItems = new ArrayList<>();
        Cursor cursor = mDatabase.query(HistoryTable.TABLE_HISTORY, HistoryTable.ALL_COLUMNS, null, null, null, null, null);

        while (cursor.moveToNext()){
            Workout workout = new Workout();
            workout.setWorkoutId(cursor.getString(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_ID)));
            workout.setWorkoutDate(cursor.getString(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_DATE)));
            workout.setWorkoutExercise1(cursor.getString(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_EXERCISE_1)));
            workout.setWorkoutReps1(cursor.getInt(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_REPS_1)));
            workout.setWorkoutSets1(cursor.getInt(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_SETS_1)));
            workout.setWorkoutExercise2(cursor.getString(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_EXERCISE_2)));
            workout.setWorkoutReps2(cursor.getInt(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_REPS_2)));
            workout.setWorkoutSets2(cursor.getInt(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_SETS_2)));
            workout.setWorkoutExercise3(cursor.getString(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_EXERCISE_3)));
            workout.setWorkoutReps3(cursor.getInt(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_REPS_3)));
            workout.setWorkoutSets3(cursor.getInt(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_SETS_3)));
            workout.setWorkoutExercise4(cursor.getString(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_EXERCISE_4)));
            workout.setWorkoutReps4(cursor.getInt(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_REPS_4)));
            workout.setWorkoutSets4(cursor.getInt(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_SETS_4)));
            workout.setWorkoutExercise5(cursor.getString(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_EXERCISE_5)));
            workout.setWorkoutReps5(cursor.getInt(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_REPS_5)));
            workout.setWorkoutSets5(cursor.getInt(cursor.getColumnIndex(HistoryTable.COLUMN_WORKOUT_SETS_5)));
            workoutItems.add(workout);
        }
        cursor.close();
        return workoutItems;
    }
}
