package com.example.schoolapp.Activity.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/8/22.
 */

public class Activity_lecturedetails extends AppCompatActivity {
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecturedetails);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        show();
    }

    public void show(){
        imageView1 = (ImageView)findViewById(R.id.lecture_one);
        imageView2 = (ImageView)findViewById(R.id.lecture_two);
        imageView3 = (ImageView)findViewById(R.id.lecture_three);

        Intent intent = getIntent();
        String key_result = intent.getStringExtra("key");
        if(key_result.equals("one")){
            imageView1.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.GONE);
            imageView3.setVisibility(View.GONE);
        }
        else if(key_result.equals("two")){
            imageView1.setVisibility(View.GONE);
            imageView2.setVisibility(View.VISIBLE);
            imageView3.setVisibility(View.GONE);
        }
        else if (key_result.equals("three")){
            imageView1.setVisibility(View.GONE);
            imageView2.setVisibility(View.GONE);
            imageView3.setVisibility(View.VISIBLE);
        }

    }
}
