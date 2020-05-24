package com.example.schoolapp.Activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolapp.MainActivity;
import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/8/29.
 */

public class Activity_login extends AppCompatActivity {
    private TextView log_text;
    private Button register_b;
    private EditText phonum;
    private EditText answer;
    private TextView sendmsg;
    private String state;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        work();
    }

    public void init() {
        log_text = (TextView) findViewById(R.id.log_text);
        register_b = (Button) findViewById(R.id.register_b);
        phonum = (EditText)findViewById(R.id.phonum);
        answer = (EditText)findViewById(R.id.answer);
        sendmsg = (TextView)findViewById(R.id.sendmsg);
    }


    public void work() {
        log_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = "log";
                Intent intent = new Intent();
                intent.setClass(Activity_login.this, Activity_gesturelog.class);
                intent.putExtra("state",state);
                startActivity(intent);
                Activity_login.this.finish();
            }
        });

        register_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pho = String.valueOf(phonum.getText());
                String ans = String.valueOf(answer.getText());
                if(TextUtils.isEmpty(pho)){
                    Toast.makeText(Activity_login.this,"手机号码不能为空！",Toast.LENGTH_SHORT).show();//必要时候判断手机号码格式
                }
                else if(TextUtils.isEmpty(ans)){
                    Toast.makeText(Activity_login.this,"验证码未输入！",Toast.LENGTH_SHORT).show();
                }
                else {
                    state = "registerone";
                    Intent intent = new Intent();
                    intent.setClass(Activity_login.this, Activity_identity.class);
                    intent.putExtra("state",state);
                    startActivity(intent);
                    Activity_login.this.finish();
                }
            }
        });


        sendmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendmsg.setText("验证码已发送");
            }
        });
    }


}
