package com.example.schoolapp.Activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/9/10.
 */

public class Activity_gesture extends AppCompatActivity {
    private GestureLockViewGroup mGestureLockViewGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mGestureLockViewGroup = (GestureLockViewGroup) findViewById(R.id.id_gestureLockViewGroup);
        mGestureLockViewGroup.setAnswer(new int[] { 1, 2, 3, 4,5 });
        mGestureLockViewGroup
                .setOnGestureLockViewListener(new GestureLockViewGroup.OnGestureLockViewListener()
                {

                    @Override
                    public void onUnmatchedExceedBoundary()
                    {
                      /*  Toast.makeText(Activity_gesture.this, "错误5次...",
                                Toast.LENGTH_SHORT).show();*/
                        mGestureLockViewGroup.setUnMatchExceedBoundary(5);
                    }

                    @Override
                    public void onGestureEvent(boolean matched)
                    {
                     /*   Toast.makeText(Activity_gesture.this, matched+"",
                                Toast.LENGTH_SHORT).show();*/
                     Toast.makeText(Activity_gesture.this,"绘制密码成功！",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(Activity_gesture.this,Activity_gesturetwo.class);
                        startActivity(intent);
                        Activity_gesture.this.finish();
                    }

                    @Override
                    public void onBlockSelected(int cId)
                    {
                    }
                });
    }


}
