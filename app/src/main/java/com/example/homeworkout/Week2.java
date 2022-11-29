package com.example.homeworkout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeworkout.dashboard.WeekWiseDayViewAdapter;
import com.example.homeworkout.modelData.CourseModelData;

import java.util.ArrayList;

public class Week2 extends Fragment {
    String courseName;
    WeekWiseDayViewAdapter weekWiseDayViewAdapter;
    ArrayList<CourseModelData> arrayList = new ArrayList<>();
    RecyclerView Week2RV;

    public Week2(String selectedCourseName) {
        this.courseName = selectedCourseName;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayList.clear();
        arrayList.add(new CourseModelData(1, 0));
        arrayList.add(new CourseModelData(2, 0));
        arrayList.add(new CourseModelData(3, 0));
        arrayList.add(new CourseModelData(4, 0));
        arrayList.add(new CourseModelData(5, 0));
        arrayList.add(new CourseModelData(6, 0));
        arrayList.add(new CourseModelData(7, 0));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_week2, container, false);
        Week2RV = view.findViewById(R.id.weeks2_rv);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        weekWiseDayViewAdapter = new WeekWiseDayViewAdapter(arrayList, getActivity(), courseName, 2);
        Week2RV.setLayoutManager(new LinearLayoutManager(getActivity()));
        Week2RV.setAdapter(weekWiseDayViewAdapter);

    }
}