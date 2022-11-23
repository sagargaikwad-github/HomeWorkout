package com.example.homeworkout.modelData;

public class CourseModelData {
    int Workout_day;

    int Workout_progress;

    public CourseModelData(int workout_day , int workout_progress) {
        Workout_day = workout_day;
        Workout_progress = workout_progress;
    }

    public int getWorkout_day() {
        return Workout_day;
    }

    public void setWorkout_day(int workout_day) {
        Workout_day = workout_day;
    }

    public int getWorkout_progress() {
        return Workout_progress;
    }

    public void setWorkout_progress(int workout_progress) {
        Workout_progress = workout_progress;
    }
}
