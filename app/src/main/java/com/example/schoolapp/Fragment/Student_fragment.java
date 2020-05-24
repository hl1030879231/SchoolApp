package com.example.schoolapp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.schoolapp.Activity.student.Activity_achievement;
import com.example.schoolapp.Activity.student.Activity_corporation;
import com.example.schoolapp.Activity.student.Activity_game;
import com.example.schoolapp.Activity.student.Activity_grades;
import com.example.schoolapp.Activity.student.Activity_lecture;
import com.example.schoolapp.Activity.student.Activity_maj;
import com.example.schoolapp.Activity.student.Activity_sch;
import com.example.schoolapp.Activity.student.Activity_stuwatch;
import com.example.schoolapp.Activity.student.Activity_timetable;
import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/8/14.
 */

public class Student_fragment extends android.support.v4.app.Fragment {
    private LinearLayout sch_message;
    private LinearLayout stu_message;
    private ScrollView sch_layout;
    private LinearLayout stu_layout;
    private TextView text_c;
    private LinearLayout timetable;
    private LinearLayout achievement;
    private LinearLayout stu_watch;
    private LinearLayout lecture;
    private LinearLayout game;
    private LinearLayout price;
    private LinearLayout corporation;
    private LinearLayout intro_major;
    private LinearLayout intro_major2;
    private LinearLayout intro_sch;
    private TextView text_sch;
    private TextView text_stu;
    private ImageView line6_1;
    private ImageView line6_2;
    private String state;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.student_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        jump();
        showintro();
    }

    public void init(){
        sch_message = (LinearLayout)getActivity().findViewById(R.id.sch_message);
        sch_layout = (ScrollView) getActivity().findViewById(R.id.sch_layout);
        stu_layout = (LinearLayout)getActivity().findViewById(R.id.stu_layout);
        stu_message = (LinearLayout)getActivity().findViewById(R.id.stu_message);
        text_c = (TextView)getActivity().findViewById(R.id.text_c);
        text_sch = (TextView)getActivity().findViewById(R.id.text_sch);
        text_stu = (TextView)getActivity().findViewById(R.id.text_stu);
        intro_major = (LinearLayout)getActivity().findViewById(R.id.intro_major);
        intro_major2 = (LinearLayout)getActivity().findViewById(R.id.intro_major2);
        intro_sch = (LinearLayout)getActivity().findViewById(R.id.intro_sch);
        timetable = (LinearLayout)getActivity().findViewById(R.id.timetable);

        text_sch.setTextColor(getContext().getResources().getColor(R.color.me_blue));

        text_c.setText("学  生");

        sch_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sch_layout.setVisibility(View.VISIBLE);
                stu_layout.setVisibility(View.GONE);
                text_stu.setTextColor(getContext().getResources().getColor(R.color.text_black));
                text_sch.setTextColor(getContext().getResources().getColor(R.color.me_blue));
                line6_1.setVisibility(View.VISIBLE);
                line6_2.setVisibility(View.GONE);

            }
        });

        stu_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sch_layout.setVisibility(View.GONE);
                stu_layout.setVisibility(View.VISIBLE);
                text_stu.setTextColor(getContext().getResources().getColor(R.color.me_blue));
                text_sch.setTextColor(getContext().getResources().getColor(R.color.text_black));
            }
        });
    }

    public void jump(){
        timetable = (LinearLayout)getActivity().findViewById(R.id.timetable);
        achievement = (LinearLayout)getActivity().findViewById(R.id.achievement);
        stu_watch = (LinearLayout)getActivity().findViewById(R.id.stu_watch);
        lecture = (LinearLayout)getActivity().findViewById(R.id.lecture);
        game = (LinearLayout)getActivity().findViewById(R.id.game);
        price = (LinearLayout)getActivity().findViewById(R.id.price);
        corporation = (LinearLayout)getActivity().findViewById(R.id.corporation);

        achievement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.setClass(getContext(), Activity_grades.class);
                startActivity(intent1);
            }
        });

        lecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                intent2.setClass(getContext(),Activity_lecture.class);
                startActivity(intent2);
            }
        });

        stu_watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent();
                intent3.setClass(getContext(),Activity_stuwatch.class);
                startActivity(intent3);
            }
        });

        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent();
                intent4.setClass(getContext(),Activity_game.class);
                startActivity(intent4);
            }
        });

        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5 = new Intent();
                intent5.setClass(getContext(),Activity_achievement.class);
                startActivity(intent5);
            }
        });

        corporation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 = new Intent();
                intent6.setClass(getContext(),Activity_corporation.class);
                startActivity(intent6);
            }
        });

        timetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7 = new Intent();
                intent7.setClass(getContext(),Activity_timetable.class);
                startActivity(intent7);
            }
        });
    }

    public void showintro(){
        intro_sch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(getContext(), Activity_sch.class);
                startActivity(intent);
            }
        });

        intro_major.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = "one";
                Intent intent1 = new Intent();
                intent1.setClass(getContext(), Activity_maj.class);
                intent1.putExtra("state",state);
                startActivity(intent1);
            }
        });
        intro_major2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = "two";
                Intent intent1 = new Intent();
                intent1.setClass(getContext(), Activity_maj.class);
                intent1.putExtra("state",state);
                startActivity(intent1);
            }
        });
    }
}
