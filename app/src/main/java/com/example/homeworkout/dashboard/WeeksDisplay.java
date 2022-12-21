package com.example.homeworkout.dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.Toolbar;

import com.example.homeworkout.R;
import com.example.homeworkout.Week1;
import com.example.homeworkout.Week2;
import com.example.homeworkout.Week3;
import com.example.homeworkout.Week4;
import com.example.homeworkout.modelData.WeeksData;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class WeeksDisplay extends AppCompatActivity  {
    String SelectedCourseName;
    int SelectedCourseID;

    ImageView week_display_back_IV;
    Toolbar week_display_Toolbar;
    ArrayList<WeeksData>weeksDataArrayList=new ArrayList<>();
    RecyclerView weeks_rv;
    WeeksDisplayAdapter weeksDisplayAdapter;


    TabLayout tabLayout;
    ViewPager2 viewPager2;

    ViewPagerFragmentAdapter viewPagerFragmentAdapter;
    private String[] Weeks = new String[]{"Week1", "Week2", "Week3","Week4"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weeks_display);


        week_display_Toolbar=findViewById(R.id.week_display_toolbar);
        week_display_back_IV=findViewById(R.id.week_display_back_IV);
       // weeks_rv=findViewById(R.id.weeks_rv);

        Bundle bundle=getIntent().getExtras();
        SelectedCourseName=bundle.getString("Selected Course Name");


        //SelectedCourseID=bundle.getInt("Selected Course Id");

        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.view_pager2);

        viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(this);
        // set adapter to viewPager2
        viewPager2.setAdapter(viewPagerFragmentAdapter);

        setSupportActionBar(week_display_Toolbar);


        weeksDataArrayList.add(new WeeksData(1));
        weeksDataArrayList.add(new WeeksData(2));
        weeksDataArrayList.add(new WeeksData(3));
        weeksDataArrayList.add(new WeeksData(4));

        new TabLayoutMediator(tabLayout,viewPager2,(tab, position) -> {
                   tab.setText(Weeks[position]);
        }).attach();
         viewPager2.setCurrentItem(0,true);


//        SqliteDataClass sqliteDataClass=new SqliteDataClass(WeeksDisplay.this);
//        weeksDataArrayList=sqliteDataClass.getWeeklyData(SelectedCourseName);


        ButtonClicks();

    }

    private void ButtonClicks() {
        week_display_back_IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void setSupportActionBar(Toolbar week_display_toolbar) {
        week_display_toolbar.setTitle(SelectedCourseName);
        week_display_toolbar.setTitleTextColor(Color.WHITE);
    }

    @Override
    protected void onResume() {
        super.onResume();

//        weeks_rv.setLayoutManager(new LinearLayoutManager(this));
//        weeksDisplayAdapter=new WeeksDisplayAdapter(weeksDataArrayList,this,SelectedCourseName);
//        weeks_rv.setAdapter(weeksDisplayAdapter);
    }

    private class ViewPagerFragmentAdapter extends FragmentStateAdapter {
        public ViewPagerFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position)
            {
                case 0:
                    return new Week1(SelectedCourseName);
                case 1:
                    return new Week2(SelectedCourseName);
                case 2:
                    return new Week3(SelectedCourseName);
                case 3:
                    return new Week4(SelectedCourseName);
            }
            return null;
        }

        @Override
        public int getItemCount() {
            return Weeks.length;
        }
    }
}