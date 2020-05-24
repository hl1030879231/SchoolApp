package com.example.schoolapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/8/19.
 */

public class Activity_newsdetails extends AppCompatActivity {
    private LinearLayout title_l;
    private ScrollView biye;
    private ScrollView xuesheng;
    private ScrollView junxun;
    private ScrollView xuexiao;
    private ImageView collect_p;
    private int state = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetails);
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
        biye = (ScrollView)findViewById(R.id.s_biye);
        xuesheng = (ScrollView)findViewById(R.id.s_xinsheng);
        junxun = (ScrollView)findViewById(R.id.s_junxuan);
        xuexiao = (ScrollView)findViewById(R.id.s_xuexiao);

        Intent intent = getIntent();
       String key2 = String.valueOf(intent.getStringExtra("key"));
        Log.e("this",key2);
        if (key2.equals("zero")){
            biye.setVisibility(View.VISIBLE);
            xuexiao.setVisibility(View.GONE);
            xuesheng.setVisibility(View.GONE);
            junxun.setVisibility(View.GONE);
        }
        else if (key2.equals("one")){
            biye.setVisibility(View.GONE);
            xuexiao.setVisibility(View.GONE);
            xuesheng.setVisibility(View.VISIBLE);
            junxun.setVisibility(View.GONE);
        }
        if (key2.equals("two")){
            biye.setVisibility(View.GONE);
            xuexiao.setVisibility(View.GONE);
            xuesheng.setVisibility(View.GONE);
            junxun.setVisibility(View.VISIBLE);
        }
        if (key2.equals("three")){
            biye.setVisibility(View.GONE);
            xuexiao.setVisibility(View.VISIBLE);
            xuesheng.setVisibility(View.GONE);
            junxun.setVisibility(View.GONE);
        }

    }
}
