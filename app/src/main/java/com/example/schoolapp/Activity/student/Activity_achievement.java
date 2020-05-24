package com.example.schoolapp.Activity.student;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolapp.Adapter.Adapter_achievement;
import com.example.schoolapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by $HL on 2017/8/22.
 */

public class Activity_achievement extends AppCompatActivity {
    private LinearLayout title_l;
    private TextView text_c;
    private ListView listView_achievement;
    private Adapter_achievement adapter_achievement;
    private List<Map<String, Object>> data;
    private ImageView good;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);
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
        good = (ImageView)findViewById(R.id.good);

        good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                good.setImageResource(R.drawable.good_d);
                Toast.makeText(Activity_achievement.this,"您的点赞信息将以短信形式发送给您的孩子。",Toast.LENGTH_SHORT).show();
            }
        });

        text_c.setText("获 奖 情 况");
    }

    public void showlist(){
        listView_achievement = (ListView)findViewById(R.id.listview_achievement);
        data = getData();
        adapter_achievement = new Adapter_achievement(this,data);
        listView_achievement.setAdapter(adapter_achievement);
        adapter_achievement.notifyDataSetChanged();

    }


    private List<Map<String, Object>> getData()
    {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
/*        Map<String, Object> map;*/
        Map<String, Object> map1;
/*        Map<String, Object> map2;*/
/*        map = new HashMap<String, Object>();*/
        map1 = new HashMap<String, Object>();
 /*       map2 = new HashMap<String, Object>();*/
      /*  map.put("title", "关于举办“如何设计一堂课”教学讲座通知");
        map.put("time", "2017年5月4日（周四)下午13：30-15：30");
        map.put("where","教师教学发展中心（下沙校区金字塔）");
        map.put("host", "浙江A大学教师教学发展中心");*/


        map1.put("title", "第四届全国AA创业大赛");
        map1.put("time", "2017年3月15日-6月7日");
        map1.put("reward","个人单项奖");
        map1.put("imageid", R.drawable.achieve);

 /*       map2.put("title", "2017人文大讲堂开讲暨启动仪式:彭林\"学礼 立德 树人\"");
        map2.put("time", "2017年3月21日 下午1：30-4：00");
        map2.put("where","浙江A大学下沙校区综合楼一楼报告厅");
        map2.put("host", "省社科联 省文明办 浙江日报报业集团");*/

    /*    list.add(map);*/
        list.add(map1);
    /*    list.add(map2);*/

        return list;
    }
}
