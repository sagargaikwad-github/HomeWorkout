package com.example.homeworkout.dashboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeworkout.R;
import com.example.homeworkout.modelData.WeeksData;
import com.example.homeworkout.sqLiteData.SqliteDataClass;

import java.util.ArrayList;

public class WeeksDisplayAdapter extends RecyclerView.Adapter<WeeksDisplayAdapter.holder> {
    ArrayList<WeeksData>arrayList;
    Context context;
    String selectedCourseName;

    public WeeksDisplayAdapter(ArrayList<WeeksData> arrayList, Context context, String selectedCourseName) {
        this.arrayList = arrayList;
        this.context = context;
        this.selectedCourseName = selectedCourseName;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.weeks_display_item,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        SqliteDataClass sqliteDataClass=new SqliteDataClass(context);

        int weekNo=arrayList.get(position).getWeek();

        holder.weekTV.setText("Week : "+weekNo);

        //Total Number of Days in a Week :
        float getDays=sqliteDataClass.getWeekDays(weekNo,selectedCourseName);

        //Total Progress from a week :
        float Progress=sqliteDataClass.getWeekProgress(weekNo,selectedCourseName);

        //Progress nonZero check
        if(Progress==0)
        {
            holder.week_progress_TV.setText("0%");
        }
       else {
           float FinalProgress=Progress/getDays;
           int TotalProgress= (int) (FinalProgress*100);
           holder.week_progress_TV.setText(String.valueOf(TotalProgress)+"%");
        }

       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(context, WeekWiseDayView.class);
               intent.putExtra("Selected Course Name",selectedCourseName);
               intent.putExtra("Selected Course Week",weekNo);
               context.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class holder extends RecyclerView.ViewHolder {
        TextView weekTV,week_progress_TV;
        public holder(@NonNull View itemView) {
            super(itemView);

            weekTV=itemView.findViewById(R.id.weekTV);
            week_progress_TV=itemView.findViewById(R.id.week_progress_TV);
        }
    }
}
