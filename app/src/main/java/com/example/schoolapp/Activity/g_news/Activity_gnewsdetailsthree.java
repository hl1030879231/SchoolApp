package com.example.schoolapp.Activity.g_news;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.schoolapp.R;

/**
 * Created by 帅气的靓仔 on 2017/9/9.
 */

public class Activity_gnewsdetailsthree extends AppCompatActivity {
    private LinearLayout title_l;
    private ScrollView gnews_one;
    private ScrollView gnews_two;
    private ScrollView gnews_three;
    private ScrollView gnews_four;
    private ScrollView gnews_five;
    private ScrollView gnews_six;
    private ImageView collect_p;
    private int state = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gnewsdetailsthree);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        showdetails();
    }

    public void init(){
        title_l = (LinearLayout)findViewById(R.id.title_l);
        title_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        collect_p = (ImageView)findViewById(R.id.collcet_p);
        collect_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(state == 0){
                    state = 1;
                    collect_p.setImageResource(R.drawable.c_d);
                }
                else if(state == 1){
                    state = 0;
                    collect_p.setImageResource(R.drawable.sc);
                }
            }
        });
    }

    public void showdetails(){
        gnews_one = (ScrollView)findViewById(R.id.speech);
        gnews_two = (ScrollView)findViewById(R.id.play);
        gnews_three = (ScrollView)findViewById(R.id.MPAcc);
        gnews_four = (ScrollView)findViewById(R.id.deal);
        gnews_five = (ScrollView)findViewById(R.id.design);
        gnews_six = (ScrollView)findViewById(R.id.phototake);


        Intent intent = getIntent();
        String key_g_result = intent.getStringExtra("key_g");

        if(key_g_result.equals("one")){
            gnews_one.setVisibility(View.VISIBLE);
            gnews_two.setVisibility(View.GONE);
            gnews_three.setVisibility(View.GONE);
            gnews_four.setVisibility(View.GONE);
            gnews_five.setVisibility(View.GONE);
            gnews_six.setVisibility(View.GONE);
        }
        else if(key_g_result.equals("two")){
            gnews_one.setVisibility(View.GONE);
            gnews_two.setVisibility(View.VISIBLE);
            gnews_three.setVisibility(View.GONE);
            gnews_four.setVisibility(View.GONE);
            gnews_five.setVisibility(View.GONE);
            gnews_six.setVisibility(View.GONE);
        }
        else if(key_g_result.equals("three")){
            gnews_one.setVisibility(View.GONE);
            gnews_two.setVisibility(View.GONE);
            gnews_three.setVisibility(View.VISIBLE);
            gnews_four.setVisibility(View.GONE);
            gnews_five.setVisibility(View.GONE);
            gnews_six.setVisibility(View.GONE);
        }
        else if(key_g_result.equals("four")){
            gnews_one.setVisibility(View.GONE);
            gnews_two.setVisibility(View.GONE);
            gnews_three.setVisibility(View.GONE);
            gnews_four.setVisibility(View.VISIBLE);
            gnews_five.setVisibility(View.GONE);
            gnews_six.setVisibility(View.GONE);
        }
        else if(key_g_result.equals("five")){
            gnews_one.setVisibility(View.GONE);
            gnews_two.setVisibility(View.GONE);
            gnews_three.setVisibility(View.GONE);
            gnews_four.setVisibility(View.GONE);
            gnews_five.setVisibility(View.VISIBLE);
            gnews_six.setVisibility(View.GONE);
        }
        else if(key_g_result.equals("six")){
            gnews_one.setVisibility(View.GONE);
            gnews_two.setVisibility(View.GONE);
            gnews_three.setVisibility(View.GONE);
            gnews_four.setVisibility(View.GONE);
            gnews_five.setVisibility(View.GONE);
            gnews_six.setVisibility(View.VISIBLE);
        }
    }
}
