package com.example.schoolapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/9/17.
 */

public class Activity_collectiondetails extends AppCompatActivity {
    private ScrollView gnews_one;
    private ScrollView gnews_two;
    private ScrollView gnews_three;
    private TextView text_c;
    private LinearLayout title_l;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collectiondetails);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        showdetails();
    }

    public void init(){
        text_c = (TextView)findViewById(R.id.text_c);
        title_l = (LinearLayout)findViewById(R.id.title_l);
        text_c.setText("我 的 收 藏");
        title_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void showdetails(){
        gnews_one = (ScrollView)findViewById(R.id.fangwenfeilvbing);
        gnews_two = (ScrollView)findViewById(R.id.huijianzhuxi);
        gnews_three = (ScrollView)findViewById(R.id.hanguodaxue);


        Intent intent = getIntent();
        String key_g_result = intent.getStringExtra("key_g");

        if(key_g_result.equals("one")){
            gnews_one.setVisibility(View.VISIBLE);
            gnews_two.setVisibility(View.GONE);
            gnews_three.setVisibility(View.GONE);
        }
        else if(key_g_result.equals("two")){
            gnews_one.setVisibility(View.GONE);
            gnews_two.setVisibility(View.VISIBLE);
            gnews_three.setVisibility(View.GONE);
        }
        else if(key_g_result.equals("three")){
            gnews_one.setVisibility(View.GONE);
            gnews_two.setVisibility(View.GONE);
            gnews_three.setVisibility(View.VISIBLE);
        }
    }
}
