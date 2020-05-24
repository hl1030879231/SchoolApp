package com.example.schoolapp.Activity.personal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.schoolapp.Other_class.SetTextSizeView;
import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/8/30.
 */

public class Activity_changesize extends AppCompatActivity{
    private SetTextSizeView setTextSizeView;
    private TextView textView;
    private LinearLayout title_l;
    private TextView text_c;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changesize);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    public void init(){
        setTextSizeView = (SetTextSizeView)findViewById(R.id.setTextSizeView);
        textView = (TextView)findViewById(R.id.changesize_text);
        title_l = (LinearLayout)findViewById(R.id.title_l);
        text_c = (TextView)findViewById(R.id.text_c);
        text_c.setText("字体大小");
        title_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        setTextSizeView.setOnPointResultListener(new SetTextSizeView.OnPointResultListener() {
            @Override
            public void onPointResult(int position) {
                if(position == 0){
                    textView.setTextSize(12);
                }
                else if(position == 1){
                    textView.setTextSize(18);
                }
                else if(position == 2){
                    textView.setTextSize(22);
                }
                else if(position == 3){
                    textView.setTextSize(27);
                }
                else if(position == 4){
                    textView.setTextSize(32);
                }
                else if(position == 5){
                    textView.setTextSize(35);
                }
            }
        });
    }
}
