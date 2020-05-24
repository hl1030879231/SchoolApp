package com.example.schoolapp.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolapp.R;

import java.util.Calendar;

/**
 * Created by $HL on 2017/8/20.
 */

public class Activity_adddata extends AppCompatActivity {
    private TextView hours_date;
    private EditText hours_context;
    private Button commit;
    private ImageView image_date;
    private int start_y;
    private int start_m ;
    private int start_d;
    private String hours_dates;
    private String hours_contexts;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddata);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    public void init(){
        hours_context = (EditText)findViewById(R.id.hours_context) ;
        hours_date = (TextView)findViewById(R.id.hours_date) ;
        image_date = (ImageView)findViewById(R.id.image_date);
        commit = (Button)findViewById(R.id.commit);
        image_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
                new DatePickerDialog(Activity_adddata.this,
                        // 绑定监听器
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                start_y = year;
                                start_m = monthOfYear + 1;
                                start_d = dayOfMonth;
                                hours_date.setText(start_y + "-" + start_m + "-" + start_d );

                            }
                        },
                        // 设置初始日期
                        c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
                        .get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hours_dates = hours_date.getText().toString();
                hours_contexts = hours_context.getText().toString();
                if(!TextUtils.isEmpty(hours_contexts) && !TextUtils.isEmpty(hours_dates)){
                    Intent intent = new Intent();
                    intent.setClass(Activity_adddata.this,Activity_data.class);
                    intent.putExtra("name",hours_contexts);
                    intent.putExtra("time",hours_dates);
                    startActivity(intent);
                }
                else if (TextUtils.isEmpty(hours_contexts)){
                    Toast.makeText(Activity_adddata.this,"纪念日名称未填写!",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(hours_dates)){
                    Toast.makeText(Activity_adddata.this,"时间未选择!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
