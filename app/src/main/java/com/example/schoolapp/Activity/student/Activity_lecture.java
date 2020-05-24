package com.example.schoolapp.Activity.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.schoolapp.Adapter.Adapter_lecture;
import com.example.schoolapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by $HL on 2017/8/22.
 */

public class Activity_lecture extends AppCompatActivity {
    private LinearLayout title_l;
    private TextView text_c;
    private ListView listView_lecture;
    private Adapter_lecture adapter_lecture;
    private List<Map<String, Object>> data;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        showlist();
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

        text_c.setText("讲 座");
    }

    public void showlist(){
        listView_lecture = (ListView)findViewById(R.id.listview_lecture);
        data = getData();
        adapter_lecture = new Adapter_lecture(this,data);
        listView_lecture.setAdapter(adapter_lecture);
        adapter_lecture.notifyDataSetChanged();

        listView_lecture.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                   Intent intent = new Intent();
                   intent.putExtra("key","one");
                   intent.setClass(Activity_lecture.this, Activity_lecturedetails.class);
                   startActivity(intent);
               }
               else if(position == 1) {
                   Intent intent = new Intent();
                   intent.putExtra("key","two");
                   intent.setClass(Activity_lecture.this, Activity_lecturedetails.class);
                   startActivity(intent);
               }
               else if (position == 2) {
                   Intent intent = new Intent();
                   intent.putExtra("key","three");
                   intent.setClass(Activity_lecture.this, Activity_lecturedetails.class);
                   startActivity(intent);
               }
            }
        });
    }

    private List<Map<String, Object>> getData()
    {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        Map<String, Object> map1;
        Map<String, Object> map2;
        map = new HashMap<String, Object>();
        map1 = new HashMap<String, Object>();
        map2 = new HashMap<String, Object>();
        map.put("title", "关于举办“如何设计一堂课”教学体验讲座的通知");
        map.put("time", "2017年5月4日（周四)下午13:30-15:30");
        map.put("where","教师教学发展中心（下沙校区金字塔）");
        map.put("host", "浙江A大学教师教学发展中心");


        map1.put("title", "教育部人文社科重点研究基地—浙江A大学商贸研究中心讲座通知");
        map1.put("time", "2017年5月17日（周三)下午13:30-15:30");
        map1.put("where","浙江A大学现代商贸研究中心436会议室");
        map1.put("host", "管理工程与电子商务学院");

        map2.put("title", "2017人文大讲堂开讲暨启动仪式:彭林\"学礼 立德 树人\"");
        map2.put("time", "2017年3月21日 下午1:30-4:00");
        map2.put("where","浙江A大学下沙校区综合楼一楼报告厅");
        map2.put("host", "省社科联 省文明办 浙江日报报业集团");

        list.add(map);
        list.add(map1);
        list.add(map2);

        return list;
    }
}
