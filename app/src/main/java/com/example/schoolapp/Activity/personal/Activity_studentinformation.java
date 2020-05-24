package com.example.schoolapp.Activity.personal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/8/15.
 */

public class Activity_studentinformation extends AppCompatActivity {
    private LinearLayout title_l;
    private TextView text_c;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentinformation_activity);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    public void init(){
        title_l = (LinearLayout)findViewById(R.id.title_l);
        text_c = (TextView)findViewById(R.id.text_c);
        title_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        text_c.setText("学生信息");
    }
}
