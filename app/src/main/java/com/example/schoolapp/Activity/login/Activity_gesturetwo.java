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

public class Activity_gesturetwo extends AppCompatActivity {
    private GestureLockViewGroup mGestureLockViewGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesturetwo);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mGestureLockViewGroup = (GestureLockViewGroup) findViewById(R.id.id_gestureLockViewGroupthree);
        mGestureLockViewGroup.setAnswer(new int[] { 1, 2, 3, 4,5 });
        mGestureLockViewGroup
                .setOnGestureLockViewListener(new GestureLockViewGroup.OnGestureLockViewListener()
                {

                    @Override
                    public void onUnmatchedExceedBoundary()
                    {
                      /*  Toast.makeText(Activity_gesturetwo.this, "错误5次...",
                                Toast.LENGTH_SHORT).show();*/
                        mGestureLockViewGroup.setUnMatchExceedBoundary(5);
                    }

                    @Override
                    public void onGestureEvent(boolean matched)
                    {
                     /*   Toast.makeText(Activity_gesture.this, matched+"",
                                Toast.LENGTH_SHORT).show();*/
                     if(matched == true ){
                        Toast.makeText(Activity_gesturetwo.this,"操作成功！",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent();
                        intent.setClass(Activity_gesturetwo.this, MainActivity.class);
                        startActivity(intent);
                        Activity_gesturetwo.this.finish();
                     }
                     else{
                         Toast.makeText(Activity_gesturetwo.this,"前后输入的手势密码不一致，请重新输入",Toast.LENGTH_SHORT).show();
                     }
                    }

                    @Override
                    public void onBlockSelected(int cId)
                    {
                    }
                });
    }

}
