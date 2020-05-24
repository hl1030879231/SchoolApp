package com.example.schoolapp.Activity.student;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
/*import android.support.annotation.Nullable;*/
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.schoolapp.R;

import java.io.IOException;

/**
 * Created by $HL on 2017/8/22.
 */

public class Activity_stuwatch extends AppCompatActivity {
    private LinearLayout title_l;
    private TextView text_c;
    private VideoView video_one;
    MediaPlayer mediaPlayer;
    private ImageView video_two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        play();
    }

    public void init(){
        title_l = (LinearLayout)findViewById(R.id.title_l);
        text_c = (TextView)findViewById(R.id.text_c);
        title_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        text_c.setText("学生监督");
    }

    public void play(){
        video_one = (VideoView)findViewById(R.id.video_one);

        String uri = "android.resource://" + getPackageName() + "/" + R.raw.video;

        video_one.setVideoURI(Uri.parse(uri));

        video_one.start();

   /*     video_two = (ImageView)findViewById(R.id.video_two);*/

       /* Glide.with(Activity_stuwatch.this).load(R.raw.video).into(video_two);*/




        /* video_one.setVideoURI(Uri.parse("file:///android_asset/video.mp4"));
        MediaController mediaController = new MediaController(this);
        video_one.setMediaController(mediaController);
        video_one.start();*/
        /*try {
            //播放 assets/a2.mp3 音乐文件
            AssetFileDescriptor fd = getAssets().openFd("video");
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
