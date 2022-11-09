package com.example.homeworkout.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeworkout.R;

import java.util.ArrayList;

public class TrainingFragment extends Fragment {
    ArrayList<SelectCourseModel> courseModels=new ArrayList<>();
    SelectCourseAdapter selectCourseAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        courseModels.clear();
        courseModels.add(new SelectCourseModel(R.drawable.boy,"Begineer"));
        courseModels.add(new SelectCourseModel(R.drawable.girl,"Intermediate"));
        courseModels.add(new SelectCourseModel(R.drawable.boy,"Advanced"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_training, container, false);
        selectCourseAdapter=new SelectCourseAdapter(courseModels,getActivity());
        RecyclerView selectCourseRV=view.findViewById(R.id.selectCourseRV);
        selectCourseRV.setLayoutManager(new LinearLayoutManager(getActivity()));

        selectCourseRV.setAdapter(selectCourseAdapter);
        return view;
    }
}