package com.example.schoolapp.Activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolapp.MainActivity;
import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/9/12.
 */

public class Activity_waitrespon extends AppCompatActivity {
    private Button next_button;
    private ProgressBar mProgress;
    private TextView wait_text;
    private int mProgressStatus = 0;
    private Handler mHandler = new Handler();
    //该程序模拟填充长度为100的数组
    private int[] data = new int[100];
    int hasData = 0;//记录ProgressBar的完成进度

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waitrespon);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        work();
    }

    public void work() {
        next_button = (Button) findViewById(R.id.next_button);
        mProgress = (ProgressBar) findViewById(R.id.mProgressBar);
        wait_text = (TextView)findViewById(R.id.wait_text);

        //创建一个负责更新进度条的Handler
        final Handler mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {

                if (msg.what == 0x111) {
                    mProgress.setProgress(mProgressStatus);
                }
            }
        };

        //启动线程来执行任务
        new Thread() {
            public void run() {
                while (mProgressStatus < 100) {
                    // 获取耗时操作的完成百分比
                    mProgressStatus = doWork();
                    // 发送消息到Handler
                    Message m = new Message();
                    m.what = 0x111;
                    // 发送消息
                    mHandler.sendMessage(m);
                    next_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(Activity_waitrespon.this,"正在等待校方验证，请稍等",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
        /*        Toast.makeText(Activity_waitrespon.this,"校方验证已完成",Toast.LENGTH_SHORT).show();*/
                next_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(Activity_waitrespon.this, Activity_gesture.class);
                        startActivity(intent);
                        Activity_waitrespon.this.finish();
                    }
                });

            }
        }.start();
    }


    //模拟一个耗时的操作
    private int doWork() {
        data[hasData++] = (int) (Math.random() * 100);

        try {
            Thread.sleep(70);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return hasData;
    }
}
