package com.example.schoolapp.Activity.personal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.schoolapp.Activity.login.Activity_login;
import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/8/15.
 */

public class Activity_editinformation extends AppCompatActivity {
    private TextView title_c;
    private LinearLayout title_l;
    private Button quit;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.editinformation_activity);
        inite();
    }

    public void inite(){
        title_c = (TextView)findViewById(R.id.text_c);
        title_l = (LinearLayout)findViewById(R.id.title_l);
        quit = (Button)findViewById(R.id.quit);
        title_c.setText("编辑资料");
        title_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Activity_editinformation.this, Activity_login.class);
                startActivity(intent);
                Activity_editinformation.this.finish();
            }
        });
    }


}
