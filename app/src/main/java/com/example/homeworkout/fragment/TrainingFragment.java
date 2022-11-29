package com.example.homeworkout.fragment;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homeworkout.R;
import com.example.homeworkout.dashboard.SelectCourseAdapter;
import com.example.homeworkout.modelData.SelectCourseModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TrainingFragment extends Fragment {
    ArrayList<SelectCourseModel> courseModels=new ArrayList<>();
    SelectCourseAdapter selectCourseAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        courseModels.clear();
        courseModels.add(new SelectCourseModel(1,R.drawable.begineer,"Begineer","Perfect for below 18 years"));
        courseModels.add(new SelectCourseModel(2,R.drawable.intermediate,"Intermediate","Above 18 but did you finish Beginner ?"));
        courseModels.add(new SelectCourseModel(3,R.drawable.advanced,"Advanced","Hey Above 18, you also start From Here.."));

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