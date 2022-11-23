package com.example.homeworkout.modelData;

public class DayData {
    int weekno,dayno,workoutno,workouttimer,calories,iscompleted;
    String workoutname;

    public DayData(int weekno, int dayno, int workoutno, int workouttimer, int calories, int iscompleted, String workoutname) {
        this.weekno = weekno;
        this.dayno = dayno;
        this.workoutno = workoutno;
        this.workouttimer = workouttimer;
        this.calories = calories;
        this.iscompleted = iscompleted;
        this.workoutname = workoutname;

    }

    public int getWeekno() {
        return weekno;
    }

    public void setWeekno(int weekno) {
        this.weekno = weekno;
    }

    public int getDayno() {
        return dayno;
    }

    public void setDayno(int dayno) {
        this.dayno = dayno;
    }

    public int getWorkoutno() {
        return workoutno;
    }

    public void setWorkoutno(int workoutno) {
        this.workoutno = workoutno;
    }

    public int getWorkouttimer() {
        return workouttimer;
    }

    public void setWorkouttimer(int workouttimer) {
        this.workouttimer = workouttimer;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getIscompleted() {
        return iscompleted;
    }

    public void setIscompleted(int iscompleted) {
        this.iscompleted = iscompleted;
    }

    public String getWorkoutname() {
        return workoutname;
    }

    public void setWorkoutname(String workoutname) {
        this.workoutname = workoutname;
    }


}
