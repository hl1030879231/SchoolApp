package com.example.schoolapp;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.schoolapp.Fragment.Home_fragment;
import com.example.schoolapp.Fragment.Me_fragment;
import com.example.schoolapp.Fragment.Student_fragment;


public class MainActivity extends AppCompatActivity {
    private LinearLayout homelayout;
    private LinearLayout studentlayout;
    private LinearLayout melayout;
    private FrameLayout textlayout;            //内容layout
    private Home_fragment home_fragment;
    private Student_fragment student_fragment;
    private Me_fragment me_fragment;
    private ImageView home;
    private ImageView me;
    private ImageView stu_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        showview();
    }

    private void showview() {
        homelayout = (LinearLayout) findViewById(R.id.home);
        studentlayout = (LinearLayout) findViewById(R.id.student);
        melayout = (LinearLayout) findViewById(R.id.me);
        textlayout = (FrameLayout) findViewById(R.id.text_context);
        me = (ImageView)findViewById(R.id.imageView_me);
        stu_image = (ImageView)findViewById(R.id.imageView_stu);
        home = (ImageView)findViewById(R.id.imageView_home);


        homelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_homefragment();
                home.setImageResource(R.drawable.home_c);
                stu_image.setImageResource(R.drawable.stu);
                me.setImageResource(R.drawable.me);
            }
        });
        studentlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_studentfragment();
                stu_image.setImageResource(R.drawable.stu_c);
                home.setImageResource(R.drawable.home);
                me.setImageResource(R.drawable.me);
            }
        });
        melayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check_mefragment();
                me.setImageResource(R.drawable.me_c);
                home.setImageResource(R.drawable.home);
                stu_image.setImageResource(R.drawable.stu);
            }
        });


        check_homefragment();                                   //默认显示第一个Fragment

    }



    private void check_homefragment() {
        home_fragment = new Home_fragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.text_context,home_fragment);
        fragmentTransaction.commit();
    }

    private void check_studentfragment() {
        student_fragment = new Student_fragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.text_context, student_fragment);
        fragmentTransaction.commit();
    }

    private void check_mefragment() {
        me_fragment = new Me_fragment();
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.text_context, me_fragment);
        fragmentTransaction.commit();

    }

}
