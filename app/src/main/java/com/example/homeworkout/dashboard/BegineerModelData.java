package com.example.homeworkout.dashboard;

public class BegineerModelData {
    int Workout_day;
    String Workout_name;
    int Workout_progress;

    public BegineerModelData(int workout_day, String workout_name, int workout_progress) {
        Workout_day = workout_day;
        Workout_name = workout_name;
        Workout_progress = workout_progress;
    }

    public int getWorkout_day() {
        return Workout_day;
    }

    public void setWorkout_day(int workout_day) {
        Workout_day = workout_day;
    }

    public String getWorkout_name() {
        return Workout_name;
    }

    public void setWorkout_name(String workout_name) {
        Workout_name = workout_name;
    }

    public int getWorkout_progress() {
        return Workout_progress;
    }

    public void setWorkout_progress(int workout_progress) {
        Workout_progress = workout_progress;
    }
}
