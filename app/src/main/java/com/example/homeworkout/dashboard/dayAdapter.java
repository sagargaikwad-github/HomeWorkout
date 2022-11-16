package com.example.homeworkout.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeworkout.R;

import java.util.ArrayList;

public class dayAdapter extends RecyclerView.Adapter<dayAdapter.holder> {
    ArrayList<DayData> dayDataArrayList;
    Context context;

    public dayAdapter(ArrayList<DayData> dayDataArrayList, Context context) {
        this.dayDataArrayList = dayDataArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.dayview_item,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.day_exname_tv.setText(dayDataArrayList.get(position).workoutname);
        holder.day_extimer_tv.setText("Total Time : "+String.valueOf(dayDataArrayList.get(position).workouttimer)+" sec");

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