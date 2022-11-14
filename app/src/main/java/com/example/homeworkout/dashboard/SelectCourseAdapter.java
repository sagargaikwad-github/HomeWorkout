package com.example.homeworkout.dashboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeworkout.R;

import java.util.ArrayList;

public class SelectCourseAdapter extends RecyclerView.Adapter<SelectCourseAdapter.holder> {
    ArrayList<SelectCourseModel>courseList;
    Context context;


    public SelectCourseAdapter(ArrayList<SelectCourseModel> courseList, Context context) {
        this.courseList = courseList;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.choose_course_rv_item,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {

        holder.courseIV.setImageResource(courseList.get(position).getCourseImage());
        holder.courseTV.setText(courseList.get(position).getCourseName());

        holder.courseTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,CourseView.class);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }

    class holder extends RecyclerView.ViewHolder {
        ImageView courseIV;
        TextView courseTV;
        public holder(@NonNull View itemView) {
            super(itemView);

            courseIV=itemView.findViewById(R.id.choose_course_rv_item_IV);
            courseTV=itemView.findViewById(R.id.choose_course_rv_item_TV);
        }
    }

}
