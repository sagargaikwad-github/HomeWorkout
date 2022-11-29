package com.example.homeworkout.dashboard;

import android.annotation.SuppressLint;
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
import com.example.homeworkout.modelData.DayData;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.holder> {
    ArrayList<DayData> dayDataArrayList;
    Context context;
    String courseName;

    public DayAdapter(ArrayList<DayData> dayDataArrayList, Context context, String courseName) {
        this.dayDataArrayList = dayDataArrayList;
        this.context = context;
        this.courseName=courseName;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.dayview_item,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, @SuppressLint("RecyclerView") int position) {
        holder.day_exname_tv.setText(dayDataArrayList.get(position).getWorkoutname());
        holder.day_extimer_tv.setText("Total Time : "+String.valueOf(dayDataArrayList.get(position).getWorkouttimer())+" sec");



        holder.day_explay_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,PlayExerciseSingle.class);
                intent.putExtra("CourseName",courseName);
                intent.putExtra("week",dayDataArrayList.get(position).getWeekno());
                intent.putExtra("day",dayDataArrayList.get(position).getDayno());
                intent.putExtra("workoutNo",dayDataArrayList.get(position).getWorkoutno());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return dayDataArrayList.size();
    }

    class holder extends RecyclerView.ViewHolder {
        ImageView day_eximage_iv,day_explay_iv;
        TextView day_exname_tv,day_extimer_tv;

        public holder(@NonNull View itemView) {
            super(itemView);

            day_eximage_iv=itemView.findViewById(R.id.day_eximage_iv);
            day_explay_iv=itemView.findViewById(R.id.day_explay_iv);

            day_exname_tv=itemView.findViewById(R.id.day_exname_tv);
            day_extimer_tv=itemView.findViewById(R.id.day_extimer_tv);
        }
    }
}
