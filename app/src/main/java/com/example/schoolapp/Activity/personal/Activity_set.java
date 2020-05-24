package com.example.schoolapp.Activity.personal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.schoolapp.Activity.Activity_alluse;
import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/8/15.
 */

public class Activity_set extends AppCompatActivity {
    private TextView text_c;
    private LinearLayout title_l;
    private LinearLayout alluse;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_activity);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    public void init(){
        text_c = (TextView)findViewById(R.id.text_c);
        title_l = (LinearLayout)findViewById(R.id.title_l);
        alluse = (LinearLayout)findViewById(R.id.alluse);
        text_c.setText("设  置");
        title_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        alluse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Activity_set.this,Activity_alluse.class);
                startActivity(intent);
            }
        });
    }
}
