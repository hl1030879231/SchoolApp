package com.example.schoolapp.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.schoolapp.Activity.Activity_data;
import com.example.schoolapp.Activity.g_news.Activity_gnewsdetailsfour;
import com.example.schoolapp.Activity.g_news.Activity_gnewsdetailsone;
import com.example.schoolapp.Activity.g_news.Activity_gnewsdetailsthree;
import com.example.schoolapp.Activity.g_news.Activity_gnewsdetailstwo;
import com.example.schoolapp.Activity.Activity_newsdetails;
import com.example.schoolapp.Activity.Activity_search;
import com.example.schoolapp.Adapter.g_newsadapter.ImageAdapter_four;
import com.example.schoolapp.Adapter.g_newsadapter.ImageAdapter_three;
import com.example.schoolapp.Other_class.PicsView;
import com.example.schoolapp.Adapter.g_newsadapter.ImageAdapter;
import com.example.schoolapp.Adapter.g_newsadapter.ImageAdapter_two;
import com.example.schoolapp.R;
import com.example.schoolapp.SQLite.HoursDB;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by $HL on 2017/8/14.
 */

public class Home_fragment extends android.support.v4.app.Fragment {
    private int[] mImgIds;
    private TextView adtext;
    private int[] images;
    private String[] titles;
    private LayoutInflater mInflater;
    private PicsView picsView;
    private LinearLayout showdata;
    private ImageView newslist3;
    private TextView clear_out;
    private Gallery gallery1;
    private Gallery gallery2;
    private Gallery gallery3;
    private Gallery gallery4;
    private EditText search;
    private String key;
    private String key_g;
    private String key_g2;
    private String key_g3;
    private String key_g4;
    private HoursDB Hoursdb;  //数据库帮助类
    private List<String> event_content = new ArrayList<String>();
    private List<String> event_time = new ArrayList<String>();
    private int k = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mInflater = LayoutInflater.from(getContext());
        Hoursdb = new HoursDB(getContext(), "hours", 2);       //创建一个名为“hours”的数据库
        new Thread(new ThreadShow()).start();
        initsearch();
        init();
        initData();
        getData();
        showpageandtext();
        showGallery();
    }

    public void initsearch(){
        search = (EditText)getActivity().findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent();
                intent3.setClass(getContext(), Activity_search.class);
                startActivity(intent3);
            }
        });
    }


    public void init(){
        showdata = (LinearLayout)getActivity().findViewById(R.id.showdata);
        adtext = (TextView)getActivity().findViewById(R.id.adtext);
        clear_out = (TextView) getActivity().findViewById(R.id.clear_out);

        clear_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search.setText("");
            }
        });
        showdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), Activity_data.class);
                startActivity(intent);
            }
        });
    }

    private void initData()
    {
        mImgIds = new int[] { R.drawable.one, R.drawable.one, R.drawable.one,
                R.drawable.one,R.drawable.one,R.drawable.one,R.drawable.one};

        images = new int[]{  R.drawable.groview_one,
                R.drawable.groview_two,
                R.drawable.groview_three,
                R.drawable.groview_four,};

        titles = new String[]{
                "毕业季，A大学子书雄章",
                "新生开学指南及注意事项",
                "新生军训指南",
                "A大学简介与学校概况",
        };
    }



    public void showpageandtext(){
        picsView = (PicsView)getView().findViewById(R.id.picsviewpager);
        List<ImageView> imgList = new ArrayList<>();
        for(int i = 0; i < images.length; i++){
            ImageView iv = new ImageView(getActivity());
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setImageResource(images[i]);
            imgList.add(iv);
        }
        // 初始化数据
        picsView.addTitlesAndImages(titles, imgList);
        //mPicsViewpager.addImages(imgList);
        // 设置点击事件
        picsView.setClickListener(new PicsView.OnClickListener() {
            @Override
            public void onClick(int position) {
               if(position ==0 )
               {
                   key = "zero";
                   Intent intent = new Intent();
                   intent.setClass(getContext(), Activity_newsdetails.class);
                   intent.putExtra("key",key);
                   startActivity(intent);
               }
                else if(position ==1 )
                {
                    key = "one";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_newsdetails.class);
                    intent.putExtra("key",key);
                    startActivity(intent);
                }
                else if(position ==2 )
                {
                    key = "two";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_newsdetails.class);
                    intent.putExtra("key",key);
                    startActivity(intent);
                }
               else if(position ==3 )
               {
                   key = "three";
                   Intent intent = new Intent();
                   intent.setClass(getContext(), Activity_newsdetails.class);
                   intent.putExtra("key",key);
                   startActivity(intent);
               }

            }

            @Override
            public void onClick(View v) {

            }
        });

    }

    public void showGallery(){
        gallery1 = (Gallery)getActivity().findViewById(R.id.gallery1);
        gallery2 = (Gallery)getActivity().findViewById(R.id.gallery2);
        gallery3 = (Gallery)getActivity().findViewById(R.id.gallery3);
        gallery4 = (Gallery)getActivity().findViewById(R.id.gallery4);



        gallery1.setAdapter(new ImageAdapter(getContext()));
        gallery2.setAdapter(new ImageAdapter_two(getContext()));
        gallery3.setAdapter(new ImageAdapter_three(getContext()));
        gallery4.setAdapter(new ImageAdapter_four(getContext()));

        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) gallery1.getLayoutParams();
        WindowManager wm = (WindowManager)getActivity().getSystemService(getContext().WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        layoutParams.setMargins(-width*1/2, 0, 0, -width);

        ViewGroup.MarginLayoutParams layoutParams2 = (ViewGroup.MarginLayoutParams) gallery2.getLayoutParams();
        WindowManager wm2 = (WindowManager)getActivity().getSystemService(getContext().WINDOW_SERVICE);
        int width2 = wm2.getDefaultDisplay().getWidth();
        layoutParams2.setMargins(-width2*1/2, 0, 0, -width2);

        ViewGroup.MarginLayoutParams layoutParams3 = (ViewGroup.MarginLayoutParams) gallery3.getLayoutParams();
        WindowManager wm3 = (WindowManager)getActivity().getSystemService(getContext().WINDOW_SERVICE);
        int width3 = wm3.getDefaultDisplay().getWidth();
        layoutParams3.setMargins(-width3*1/2, 0, 0, -width3);

        ViewGroup.MarginLayoutParams layoutParams4 = (ViewGroup.MarginLayoutParams) gallery4.getLayoutParams();
        WindowManager wm4 = (WindowManager)getActivity().getSystemService(getContext().WINDOW_SERVICE);
        int width4 = wm4.getDefaultDisplay().getWidth();
        layoutParams4.setMargins(-width4*1/2, 0, 0, -width4);

        gallery1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0 ){
                key_g = "one";
                Intent intent = new Intent();
                intent.setClass(getContext(), Activity_gnewsdetailsone.class);
                intent.putExtra("key_g",key_g);
                startActivity(intent);
                }
                else if(position == 1 ){
                    key_g = "two";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsone.class);
                    intent.putExtra("key_g",key_g);
                    startActivity(intent);
                }
                else if(position == 2 ){
                    key_g = "three";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsone.class);
                    intent.putExtra("key_g",key_g);
                    startActivity(intent);
                }
                else if(position == 3 ){
                    key_g = "four";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsone.class);
                    intent.putExtra("key_g",key_g);
                    startActivity(intent);
                }
                else if(position == 4 ){
                    key_g = "five";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsone.class);
                    intent.putExtra("key_g",key_g);
                    startActivity(intent);
                }
                else if(position == 5 ){
                    key_g = "six";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsone.class);
                    intent.putExtra("key_g",key_g);
                    startActivity(intent);
                }
            }
        });


        gallery2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0 ){
                    key_g2 = "one";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailstwo.class);
                    intent.putExtra("key_g",key_g2);
                    startActivity(intent);
                }
                else if(position == 1 ){
                    key_g2 = "two";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailstwo.class);
                    intent.putExtra("key_g",key_g2);
                    startActivity(intent);
                }
                else if(position == 2 ){
                    key_g2 = "three";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailstwo.class);
                    intent.putExtra("key_g",key_g2);
                    startActivity(intent);
                }
                else if(position == 3 ){
                    key_g2 = "four";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailstwo.class);
                    intent.putExtra("key_g",key_g2);
                    startActivity(intent);
                }
                else if(position == 4 ){
                    key_g2 = "five";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailstwo.class);
                    intent.putExtra("key_g",key_g2);
                    startActivity(intent);
                }
                else if(position == 5 ){
                    key_g2 = "six";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailstwo.class);
                    intent.putExtra("key_g",key_g2);
                    startActivity(intent);
                }
            }

        });

        gallery3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0 ){
                    key_g3 = "one";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsthree.class);
                    intent.putExtra("key_g",key_g3);
                    startActivity(intent);
                }
                else if(position == 1 ){
                    key_g3 = "two";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsthree.class);
                    intent.putExtra("key_g",key_g3);
                    startActivity(intent);
                }
                else if(position == 2 ){
                    key_g3 = "three";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsthree.class);
                    intent.putExtra("key_g",key_g3);
                    startActivity(intent);
                }
                else if(position == 3 ){
                    key_g3 = "four";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsthree.class);
                    intent.putExtra("key_g",key_g3);
                    startActivity(intent);
                }
                else if(position == 4 ){
                    key_g3 = "five";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsthree.class);
                    intent.putExtra("key_g",key_g3);
                    startActivity(intent);
                }
                else if(position == 5 ){
                    key_g3 = "six";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsthree.class);
                    intent.putExtra("key_g",key_g3);
                    startActivity(intent);
                }
            }

        });


        gallery4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0 ){
                    key_g4 = "one";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsfour.class);
                    intent.putExtra("key_g",key_g4);
                    startActivity(intent);
                }
                else if(position == 1 ){
                    key_g4 = "two";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsfour.class);
                    intent.putExtra("key_g",key_g4);
                    startActivity(intent);
                }
                else if(position == 2 ){
                    key_g4 = "three";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsfour.class);
                    intent.putExtra("key_g",key_g4);
                    startActivity(intent);
                }
                else if(position == 3 ){
                    key_g4 = "four";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsfour.class);
                    intent.putExtra("key_g",key_g4);
                    startActivity(intent);
                }
                else if(position == 4 ){
                    key_g4 = "five";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsfour.class);
                    intent.putExtra("key_g",key_g4);
                    startActivity(intent);
                }
                else if(position == 5 ){
                    key_g4 = "six";
                    Intent intent = new Intent();
                    intent.setClass(getContext(), Activity_gnewsdetailsfour.class);
                    intent.putExtra("key_g",key_g4);
                    startActivity(intent);
                }
            }

        });
    }

    public void getData(){
         // 查询Book表中所有的数据
        Cursor cursor = Hoursdb.getWritableDatabase().query("time_table", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
         // 遍历Cursor对象，取出数据并打印
                String content_ev = cursor.getString(cursor. getColumnIndex("news_content"));
                String time_ev = cursor.getString(cursor.getColumnIndex("news_else"));
                event_content.add(content_ev);
                event_time.add(time_ev);
              Log.e("：", String.valueOf(event_content));
            }
            while (cursor.moveToNext());
        };
        cursor.close();
    }

    // handler类接收数据
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1 && k==0) {
                adtext.setText("距离国庆还剩 /  23天");
                k = k + 1;
            }
            else if (msg.what == 1 && k==1) {
                adtext.setText("距离中秋还剩 /  27天");
                k = k + 1;
            }
            else if (msg.what == 1 && k==2) {
                adtext.setText("距离元旦还剩 /  119天");
                k = k + 1;
            }
            else if (msg.what == 1 && k==3) {
                adtext.setText("距离四六级还剩 /  300天");
                k = k + 1;
            }
            else if (msg.what == 1 && k==4) {
                adtext.setText("距离放假还剩 /  330天");
                k = k + 1;
            }
        };
    };
    // 线程类
    class ThreadShow implements Runnable {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (true) {
                try {
                    Thread.sleep(3000);
                    Message msg = new Message();
                    msg.what = 1;
                    handler.sendMessage(msg);
                    System.out.println("send...");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    System.out.println("thread error...");
                }
            }
        }
    }

}
