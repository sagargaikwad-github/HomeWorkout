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

import java.util.ArrayList;

public class BeginnerAdapter extends RecyclerView.Adapter<BeginnerAdapter.holder> {
    ArrayList<BegineerModelData> begineerModelDataArrayList;
    Context context;

    public BeginnerAdapter(ArrayList<BegineerModelData> begineerModelDataArrayList, Context context) {
        this.begineerModelDataArrayList = begineerModelDataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.course_item,parent,false);
        return new BeginnerAdapter.holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, @SuppressLint("RecyclerView") int position) {
      holder.course_item_dayno.setText(String.valueOf(begineerModelDataArrayList.get(position).getWorkout_day()));
      holder.course_item_dayname.setText(String.valueOf(begineerModelDataArrayList.get(position).getWorkout_name()));
      holder.course_item_dayprogress.setText(String.valueOf(begineerModelDataArrayList.get(position).getWorkout_progress()));

      holder.ClickRL.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              int workoutday=begineerModelDataArrayList.get(position).getWorkout_day();
              Intent intent=new Intent(context,CourseViewMain.class);
              intent.putExtra("Day" ,workoutday);
              context.startActivity(intent);
          }
      });
    }

    @Override
    public int getItemCount() {
        return begineerModelDataArrayList.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView course_item_dayno,course_item_dayname , course_item_dayprogress;
        RelativeLayout ClickRL;

        public holder(@NonNull View itemView) {
            super(itemView);

            course_item_dayno=itemView.findViewById(R.id.course_item_dayno);
            course_item_dayname=itemView.findViewById(R.id.course_item_dayname);
            course_item_dayprogress=itemView.findViewById(R.id.course_item_dayprogress);

            ClickRL=itemView.findViewById(R.id.ClickRL);
        }
    }
}
