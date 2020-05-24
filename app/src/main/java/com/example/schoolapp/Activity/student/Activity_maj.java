package com.example.schoolapp.Activity.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/9/11.
 */

public class Activity_maj extends AppCompatActivity {
    private LinearLayout title_l;
    private TextView text_c;
    private ScrollView seedesign;
    private ScrollView endesign;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maj);
        init();
        showcontext();
    }

    public void init(){
        title_l = (LinearLayout)findViewById(R.id.title_l);
        text_c = (TextView)findViewById(R.id.text_c);
        seedesign = (ScrollView)findViewById(R.id.seedesign);
        endesign = (ScrollView)findViewById(R.id.endesign);

        title_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        text_c.setText("专 业 介 绍");
    }

    public void showcontext(){
        Intent intent = getIntent();
        String state_result = intent.getStringExtra("state");
        if(state_result.equals("one")){
            seedesign.setVisibility(View.VISIBLE);
            endesign.setVisibility(View.GONE);
        }
        else{
            seedesign.setVisibility(View.GONE);
            endesign.setVisibility(View.VISIBLE);
        }
    }
}
