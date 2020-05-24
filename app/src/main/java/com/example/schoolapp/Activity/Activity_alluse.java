package com.example.schoolapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolapp.Activity.personal.Activity_changesize;
import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/8/16.
 */

public class Activity_alluse extends AppCompatActivity {
    private TextView text_c;
    private LinearLayout title_l;
    private LinearLayout clear_buffer;
    private TextView buffer;
    private LinearLayout change_size;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alluse_activity);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    public void init(){
        text_c = (TextView)findViewById(R.id.text_c);
        title_l = (LinearLayout)findViewById(R.id.title_l);
        clear_buffer = (LinearLayout)findViewById(R.id.clear_buffer);
        buffer = (TextView)findViewById(R.id.buffer);
        change_size = (LinearLayout)findViewById(R.id.change_size);
        text_c.setText("通用");
        title_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        change_size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Activity_alluse.this,Activity_changesize.class);
                startActivity(intent);
            }
        });

        clear_buffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_alluse.this,"清除缓存成功",Toast.LENGTH_SHORT).show();
                buffer.setText("0 M");
            }
        });
    }
}
