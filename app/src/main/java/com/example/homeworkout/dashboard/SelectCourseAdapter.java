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

import com.bumptech.glide.Glide;
import com.example.homeworkout.R;
import com.example.homeworkout.modelData.SelectCourseModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;

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
    public void onBindViewHolder(@NonNull holder holder, @SuppressLint("RecyclerView") int position) {


        holder.courseTV.setText(courseList.get(position).getCourseName());
        holder.courseIV.setImageResource(courseList.get(position).getCourseImage());
        holder.coureDesc.setText(courseList.get(position).getCourseDesc());

        holder.courseTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,WeeksDisplay.class);
                intent.putExtra("Selected Course Name",courseList.get(position).getCourseName());
                intent.putExtra("Selected Course Id",courseList.get(position).getCourseID());
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
        TextView courseTV,coureDesc;
        public holder(@NonNull View itemView) {
            super(itemView);

            courseIV=itemView.findViewById(R.id.choose_course_rv_item_IV);
            courseTV=itemView.findViewById(R.id.choose_course_rv_item_TV);
            coureDesc=itemView.findViewById(R.id.choose_course_rv_item_description_TV);
        }
    }

}
