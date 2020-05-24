package com.example.schoolapp.Activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.schoolapp.MainActivity;
import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/9/10.
 */

public class Activity_gesturelog extends AppCompatActivity {
    private GestureLockViewGroup mGestureLockViewGrouplog;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesturelog);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mGestureLockViewGrouplog = (GestureLockViewGroup) findViewById(R.id.id_gestureLockViewGrouplog);
        mGestureLockViewGrouplog.setAnswer(new int[] { 1, 2, 3, 4,5 });
        mGestureLockViewGrouplog
                .setOnGestureLockViewListener(new GestureLockViewGroup.OnGestureLockViewListener()
                {

                    @Override
                    public void onUnmatchedExceedBoundary()
                    {
                        Toast.makeText(Activity_gesturelog.this, "错误5次...",
                                Toast.LENGTH_SHORT).show();
                        mGestureLockViewGrouplog.setUnMatchExceedBoundary(5);
                    }

                    @Override
                    public void onGestureEvent(boolean matched)
                    {
                     /*   Toast.makeText(Activity_gesture.this, matched+"",
                                Toast.LENGTH_SHORT).show();*/
                     if(matched){
                         Toast.makeText(Activity_gesturelog.this,"登录成功",
                                 Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(Activity_gesturelog.this, MainActivity.class);
                        startActivity(intent);
                        Activity_gesturelog.this.finish();
                     }
                     else {
                         Toast.makeText(Activity_gesturelog.this,"手势密码错误，请重新输入",
                                 Toast.LENGTH_SHORT).show();
                     }
                    }

                    @Override
                    public void onBlockSelected(int cId)
                    {
                    }
                });
    }
}
