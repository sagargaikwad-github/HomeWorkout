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
import com.google.android.material.progressindicator.CircularProgressIndicator;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.holder> {
    ArrayList<CourseModelData> courseModelDataArrayList;
    Context context;
    String selectedCourseName;
    int selectedCourseWeek;

    public CourseAdapter(ArrayList<CourseModelData> courseModelDataArrayList, Context context, String selectedCourseName, int selectedCourseWeek) {
        this.courseModelDataArrayList = courseModelDataArrayList;
        this.context = context;
        this.selectedCourseName = selectedCourseName;
        this.selectedCourseWeek = selectedCourseWeek;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.course_item,parent,false);
        return new CourseAdapter.holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, @SuppressLint("RecyclerView") int position) {


       holder.course_item_dayno.setText("Day : "+String.valueOf(courseModelDataArrayList.get(position).getWorkout_day()));
     //holder.progress.setText(String.valueOf(courseModelDataArrayList.get(position).getWorkout_progress()));

    //  holder.ProgressIndicator.setProgressCompat(dayProgress,true);
      //holder.progress.setText(String.valueOf(dayProgress+"%"));

        holder.ClickRL.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(context,CourseViewMain.class);
              intent.putExtra("Day" ,selectedCourseName);
              intent.putExtra("week" ,selectedCourseWeek);
              context.startActivity(intent);
          }
      });
    }

    @Override
    public int getItemCount() {
        return courseModelDataArrayList.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView course_item_dayno,progress;
        RelativeLayout ClickRL;
        CircularProgressIndicator ProgressIndicator;

        public holder(@NonNull View itemView) {
            super(itemView);

           course_item_dayno=itemView.findViewById(R.id.course_item_dayno);

            ProgressIndicator=itemView.findViewById(R.id.ProgressIndicator);
            ClickRL=itemView.findViewById(R.id.ClickRL);
            progress=itemView.findViewById(R.id.progress);
        }
    }
}
