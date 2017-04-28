
package com.example.keithfawcett.fawcettkeithworkoutessentials.database;


public class HistoryTable {
    public static final String TABLE_HISTORY = "workoutHistory";
    public static final String COLUMN_WORKOUT_ID = "workoutId";
    public static final String COLUMN_WORKOUT_DATE = "workoutDate";
    public static final String COLUMN_WORKOUT_EXERCISE_1 = "workoutExercise1";
    public static final String COLUMN_WORKOUT_REPS_1 = "workoutReps1";
    public static final String COLUMN_WORKOUT_SETS_1 = "workoutSets1";
    public static final String COLUMN_WORKOUT_EXERCISE_2 = "workoutExercise2";
    public static final String COLUMN_WORKOUT_REPS_2 = "workoutReps2";
    public static final String COLUMN_WORKOUT_SETS_2 = "workoutSets2";
    public static final String COLUMN_WORKOUT_EXERCISE_3 = "workoutExercise3";
    public static final String COLUMN_WORKOUT_REPS_3 = "workoutReps3";
    public static final String COLUMN_WORKOUT_SETS_3 = "workoutSets3";
    public static final String COLUMN_WORKOUT_EXERCISE_4 = "workoutExercise4";
    public static final String COLUMN_WORKOUT_REPS_4 = "workoutReps4";
    public static final String COLUMN_WORKOUT_SETS_4 = "workoutSets4";
    public static final String COLUMN_WORKOUT_EXERCISE_5 = "workoutExercise5";
    public static final String COLUMN_WORKOUT_REPS_5 = "workoutReps5";
    public static final String COLUMN_WORKOUT_SETS_5 = "workoutSets5";

    public static final String[] ALL_COLUMNS =
            {COLUMN_WORKOUT_ID, COLUMN_WORKOUT_DATE, COLUMN_WORKOUT_EXERCISE_1, COLUMN_WORKOUT_REPS_1, COLUMN_WORKOUT_SETS_1, COLUMN_WORKOUT_EXERCISE_2, COLUMN_WORKOUT_REPS_2, COLUMN_WORKOUT_SETS_2,
                    COLUMN_WORKOUT_EXERCISE_3, COLUMN_WORKOUT_REPS_3, COLUMN_WORKOUT_SETS_3, COLUMN_WORKOUT_EXERCISE_4, COLUMN_WORKOUT_REPS_4, COLUMN_WORKOUT_SETS_4,
                    COLUMN_WORKOUT_EXERCISE_5, COLUMN_WORKOUT_REPS_5, COLUMN_WORKOUT_SETS_5};

    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_HISTORY + "(" +
                    COLUMN_WORKOUT_ID + " TEXT PRIMARY KEY," +
                    COLUMN_WORKOUT_DATE + " TEXT, " +
                    COLUMN_WORKOUT_EXERCISE_1 + " TEXT," +
                    COLUMN_WORKOUT_REPS_1 + " INTEGER," +
                    COLUMN_WORKOUT_SETS_1 + " INTEGER," +
                    COLUMN_WORKOUT_EXERCISE_2 + " TEXT," +
                    COLUMN_WORKOUT_REPS_2 + " INTEGER," +
                    COLUMN_WORKOUT_SETS_2 + " INTEGER," +
                    COLUMN_WORKOUT_EXERCISE_3 + " TEXT," +
                    COLUMN_WORKOUT_REPS_3 + " INTEGER," +
                    COLUMN_WORKOUT_SETS_3 + " INTEGER," +
                    COLUMN_WORKOUT_EXERCISE_4 + " TEXT," +
                    COLUMN_WORKOUT_REPS_4 + " INTEGER," +
                    COLUMN_WORKOUT_SETS_4 + " INTEGER," +
                    COLUMN_WORKOUT_EXERCISE_5 + " TEXT," +
                    COLUMN_WORKOUT_REPS_5 + " INTEGER," +
                    COLUMN_WORKOUT_SETS_5 + " INTEGER" + ");";

    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_HISTORY;
}
