package com.example.keithfawcett.fawcettkeithworkoutessentials.model;

import android.content.ContentValues;

import com.example.keithfawcett.fawcettkeithworkoutessentials.database.HistoryTable;

import java.io.Serializable;
import java.util.UUID;


public class Workout implements Serializable {



    private String workoutId;
    private String workoutDate;
    private String workoutExercise1;
    private int workoutReps1;
    private int workoutSets1;
    private String workoutExercise2;
    private int workoutReps2;
    private int workoutSets2;
    private String workoutExercise3;
    private int workoutReps3;
    private int workoutSets3;
    private String workoutExercise4;
    private int workoutReps4;
    private int workoutSets4;
    private String workoutExercise5;
    private int workoutReps5;
    private int workoutSets5;

    public Workout() {

    }



    public Workout(String id, String date, String exercise1, int reps1, int sets1, String exercise2, int reps2, int sets2,
            String exercise3, int reps3, int sets3, String exercise4, int reps4, int sets4, String exercise5, int reps5, int sets5){

        if (id == null){
            id = UUID.randomUUID().toString();
        }


        workoutId = id;
        workoutDate = date;
        workoutExercise1 = exercise1;
        workoutReps1 = reps1;
        workoutSets1 = sets1;
        workoutExercise2 = exercise2;
        workoutReps2 = reps2;
        workoutSets2 = sets2;
        workoutExercise3 = exercise3;
        workoutReps3 = reps3;
        workoutSets3 = sets3;
        workoutExercise4 = exercise4;
        workoutReps4 = reps4;
        workoutSets4 = sets4;
        workoutExercise5 = exercise5;
        workoutReps5 = reps5;
        workoutSets5 = sets5;


    }

    @Override
    public String toString() { return workoutDate; }

    public String getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(String workoutId) {
        this.workoutId = workoutId;
    }

    public String getWorkoutDate() {
        return workoutDate;
    }

    public void setWorkoutDate(String workoutDate) {
        this.workoutDate = workoutDate;
    }

    public String getWorkoutExercise1() {
        return workoutExercise1;
    }

    public void setWorkoutExercise1(String workoutExercise1) {
        this.workoutExercise1 = workoutExercise1;
    }

    public int getWorkoutReps1() {
        return workoutReps1;
    }

    public void setWorkoutReps1(int workoutReps1) {
        this.workoutReps1 = workoutReps1;
    }

    public int getWorkoutSets1() {
        return workoutSets1;
    }

    public void setWorkoutSets1(int workoutSets1) {
        this.workoutSets1 = workoutSets1;
    }

    public String getWorkoutExercise2() {
        return workoutExercise2;
    }

    public void setWorkoutExercise2(String workoutExercise2) {
        this.workoutExercise2 = workoutExercise2;
    }

    public int getWorkoutReps2() {
        return workoutReps2;
    }

    public void setWorkoutReps2(int workoutReps2) {
        this.workoutReps2 = workoutReps2;
    }

    public int getWorkoutSets2() {
        return workoutSets2;
    }

    public void setWorkoutSets2(int workoutSets2) {
        this.workoutSets2 = workoutSets2;
    }

    public String getWorkoutExercise3() {
        return workoutExercise3;
    }

    public void setWorkoutExercise3(String workoutExercise3) {
        this.workoutExercise3 = workoutExercise3;
    }

    public int getWorkoutReps3() {
        return workoutReps3;
    }

    public void setWorkoutReps3(int workoutReps3) {
        this.workoutReps3 = workoutReps3;
    }

    public int getWorkoutSets3() {
        return workoutSets3;
    }

    public void setWorkoutSets3(int workoutSets3) {
        this.workoutSets3 = workoutSets3;
    }

    public String getWorkoutExercise4() {
        return workoutExercise4;
    }

    public void setWorkoutExercise4(String workoutExercise4) {
        this.workoutExercise4 = workoutExercise4;
    }

    public int getWorkoutReps4() {
        return workoutReps4;
    }

    public void setWorkoutReps4(int workoutReps4) {
        this.workoutReps4 = workoutReps4;
    }

    public int getWorkoutSets4() {
        return workoutSets4;
    }

    public void setWorkoutSets4(int workoutSets4) {
        this.workoutSets4 = workoutSets4;
    }

    public String getWorkoutExercise5() {
        return workoutExercise5;
    }

    public void setWorkoutExercise5(String workoutExercise5) {
        this.workoutExercise5 = workoutExercise5;
    }

    public int getWorkoutReps5() {
        return workoutReps5;
    }

    public void setWorkoutReps5(int workoutReps5) {
        this.workoutReps5 = workoutReps5;
    }

    public int getWorkoutSets5() {
        return workoutSets5;
    }

    public void setWorkoutSets5(int workoutSets5) {
        this.workoutSets5 = workoutSets5;
    }


    public ContentValues toValues(){
        ContentValues values = new ContentValues(17);

        values.put(HistoryTable.COLUMN_WORKOUT_ID, workoutId);
        values.put(HistoryTable.COLUMN_WORKOUT_DATE, workoutDate);
        values.put(HistoryTable.COLUMN_WORKOUT_EXERCISE_1, workoutExercise1);
        values.put(HistoryTable.COLUMN_WORKOUT_REPS_1, workoutReps1);
        values.put(HistoryTable.COLUMN_WORKOUT_SETS_1, workoutSets1);
        values.put(HistoryTable.COLUMN_WORKOUT_EXERCISE_2, workoutExercise2);
        values.put(HistoryTable.COLUMN_WORKOUT_REPS_2, workoutReps2);
        values.put(HistoryTable.COLUMN_WORKOUT_SETS_2, workoutSets2);
        values.put(HistoryTable.COLUMN_WORKOUT_EXERCISE_3, workoutExercise3);
        values.put(HistoryTable.COLUMN_WORKOUT_REPS_3, workoutReps3);
        values.put(HistoryTable.COLUMN_WORKOUT_SETS_3, workoutSets3);
        values.put(HistoryTable.COLUMN_WORKOUT_EXERCISE_4, workoutExercise4);
        values.put(HistoryTable.COLUMN_WORKOUT_REPS_4, workoutReps4);
        values.put(HistoryTable.COLUMN_WORKOUT_SETS_4, workoutSets4);
        values.put(HistoryTable.COLUMN_WORKOUT_EXERCISE_5, workoutExercise5);
        values.put(HistoryTable.COLUMN_WORKOUT_REPS_5, workoutReps5);
        values.put(HistoryTable.COLUMN_WORKOUT_SETS_5, workoutSets5);
        return values;

    }











}
