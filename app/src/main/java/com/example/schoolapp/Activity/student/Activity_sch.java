package com.example.schoolapp.Activity.student;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.schoolapp.R;

import org.w3c.dom.Text;

/**
 * Created by $HL on 2017/9/11.
 */

public class Activity_sch extends AppCompatActivity {
    private LinearLayout title_l;
    private TextView text_c;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sch);
        init();
    }

    public void init(){
        title_l = (LinearLayout)findViewById(R.id.title_l);
        text_c = (TextView)findViewById(R.id.text_c);
        title_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        text_c.setText("学 院 介 绍");
    }
}
