package com.example.homeworkout.dashboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeworkout.R;
import com.example.homeworkout.modelData.CourseModelData;
import com.example.homeworkout.sqLiteData.SqliteDataClass;
import com.google.android.material.progressindicator.CircularProgressIndicator;

import java.util.ArrayList;

public class WeekWiseDayViewAdapter extends RecyclerView.Adapter<WeekWiseDayViewAdapter.holder> {
    ArrayList<CourseModelData> courseModelDataArrayList;
    Context context;
    String selectedCourseName;
    int selectedCourseWeek;

    public WeekWiseDayViewAdapter(ArrayList<CourseModelData> courseModelDataArrayList, Context context, String selectedCourseName, int selectedCourseWeek) {
        this.courseModelDataArrayList = courseModelDataArrayList;
        this.context = context;
        this.selectedCourseName = selectedCourseName;
        this.selectedCourseWeek = selectedCourseWeek;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.course_item, parent, false);
        return new WeekWiseDayViewAdapter.holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, @SuppressLint("RecyclerView") int position) {

        SqliteDataClass sqliteDataClass = new SqliteDataClass(context);

        //First We find a Whole Day Progress from database
        float Progress = sqliteDataClass.getDayProgress(selectedCourseWeek, selectedCourseName, courseModelDataArrayList.get(position).getWorkout_day());

        //If Not a single task is Completed that day it will give 0 so,
        if (Progress == 0) {
            holder.progress.setText(String.valueOf(Progress + "%"));
        }

        //If Progress is not 0 then,
        else {

            //Getting Float Because,
            //If Progress is 1 Divide by 7 Days gives , int 0 and Float 0.1428
            //we need to Update Indicator so we get a Float Value. and find a Percentage of Progress
            //Percentage Formula : (value/TotalValue)*100;

            float TotalProgress = Progress / 7;
            float FinalProgress = TotalProgress * 100;


            //Math.round Because ProgressIndicator needs Int Value.
            holder.ProgressIndicator.setProgress(Math.round(FinalProgress), true);

            //Converted to int because we need Round Figure Percentage like 71% not 71.22%
            holder.progress.setText(String.valueOf((int) FinalProgress) + "%");
        }


        //This arraylist used to find a Rest Day from a Database
        //For finding rest day we will provide selectedCourseName and selectedCourseWeek parameters
        //E.g  selectedCourseName='Beginner' and selectedCourseWeek=1

        ArrayList<Integer> arrayList = sqliteDataClass.getRestDay(selectedCourseName, selectedCourseWeek);

        for (int i = 0; i < arrayList.size(); i++) {

            //If ArrayList index data and courseModelDataArrayList workoutDay data will Equal that Time We Found a Rest Day

            if (arrayList.get(i).equals(courseModelDataArrayList.get(position).getWorkout_day())) {
                holder.course_item_dayno.setText("Rest Day");

                //Here we also Update ProgressIndicator and Progress Text Because Rest Day test Needs To update when Rest Day Founds
                holder.ProgressIndicator.hide();
                holder.progress.setText("");
            } else {
                holder.course_item_dayno.setText("Day : " + String.valueOf(courseModelDataArrayList.get(position).getWorkout_day()));
            }
        }


        holder.ClickRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DayView.class);
                intent.putExtra("CourseName", selectedCourseName);
                intent.putExtra("Week", selectedCourseWeek);
                intent.putExtra("Day", courseModelDataArrayList.get(position).getWorkout_day());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseModelDataArrayList.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView course_item_dayno, progress;
        RelativeLayout ClickRL;
        CircularProgressIndicator ProgressIndicator;

        public holder(@NonNull View itemView) {
            super(itemView);

            course_item_dayno = itemView.findViewById(R.id.course_item_dayno);

            ProgressIndicator = itemView.findViewById(R.id.ProgressIndicator);
            ClickRL = itemView.findViewById(R.id.ClickRL);
            progress = itemView.findViewById(R.id.progress);
        }
    }
}
