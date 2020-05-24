package com.example.schoolapp.Activity.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.schoolapp.Adapter.Adapter_game;
import com.example.schoolapp.Adapter.Recycleview_adapter;
import com.example.schoolapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by $HL on 2017/8/22.
 */

public class Activity_game extends AppCompatActivity {
    private LinearLayout title_l;
    private TextView text_c;
    private ListView listView_game;
    private Adapter_game adapter_game;
    private List<Map<String, Object>> data;
    private RecyclerView recyclerView;
    private Recycleview_adapter  recycleview_adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
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

        text_c.setText("竞   赛");
    }

    public void showlist(){
        recyclerView = (RecyclerView)findViewById(R.id.recycle_game);
       /* listView_game = (ListView)findViewById(R.id.listview_game);*/
        data = getData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//设置布局管理器
       /* recyclerView.addItemDecoration(new DividerItemDecoration(this));*/
        recyclerView.setAdapter(recycleview_adapter=new Recycleview_adapter(this,data));

        recycleview_adapter.setOnItemClickListener(new Recycleview_adapter.MyViewHolder.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
               /* Intent intent = new Intent();
                intent.putExtra("key","one");
                intent.setClass(Activity_game.this, Activity_gamedetails.class);
                startActivity(intent);*/
                if (postion == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("key","one");
                    intent.setClass(Activity_game.this, Activity_gamedetails.class);
                    startActivity(intent);
                }
                else if(postion == 1) {
                    Intent intent = new Intent();
                    intent.putExtra("key","two");
                    intent.setClass(Activity_game.this, Activity_gamedetails.class);
                    startActivity(intent);
                }
                else if (postion == 2) {
                    Intent intent = new Intent();
                    intent.putExtra("key","three");
                    intent.setClass(Activity_game.this, Activity_gamedetails.class);
                    startActivity(intent);
                }
                else if (postion == 3) {
                    Intent intent = new Intent();
                    intent.putExtra("key","four");
                    intent.setClass(Activity_game.this, Activity_gamedetails.class);
                    startActivity(intent);
                }
            }
        });

       /* adapter_game = new Adapter_game(this,data);
        listView_game.setAdapter(adapter_game);
        adapter_game.notifyDataSetChanged();

       listView_game.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              *//* Intent intent = new Intent();
               intent.putExtra("key","one");
               intent.setClass(Activity_game.this, Activity_gamedetails.class);
               startActivity(intent);*//*
               if (i == 0) {
                   Intent intent = new Intent();
                   intent.putExtra("key","one");
                   intent.setClass(Activity_game.this, Activity_gamedetails.class);
                   startActivity(intent);
               }
               else if(i == 1) {
                   Intent intent = new Intent();
                   intent.putExtra("key","two");
                   intent.setClass(Activity_game.this, Activity_gamedetails.class);
                   startActivity(intent);
               }
               else if (i == 2) {
                   Intent intent = new Intent();
                   intent.putExtra("key","three");
                   intent.setClass(Activity_game.this, Activity_gamedetails.class);
                   startActivity(intent);
               }
               else if (i == 3) {
                   Intent intent = new Intent();
                   intent.putExtra("key","four");
                   intent.setClass(Activity_game.this, Activity_gamedetails.class);
                   startActivity(intent);
               }
           }
       });*/
    }


    private List<Map<String, Object>> getData()
    {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map;
        Map<String, Object> map1;
        Map<String, Object> map2;
        Map<String, Object> map3;
        map = new HashMap<String, Object>();
        map1 = new HashMap<String, Object>();
        map2 = new HashMap<String, Object>();
        map3 = new HashMap<String, Object>();


        map.put("img", R.mipmap.game1);
        map.put("title", "第十二届公益广告大赛");
        map.put("time","官网：http://www.szpsa.org/");
        map.put("info", "2017竞赛征集第十二届公益广告大赛是全国首个以公益为主题的广告大赛……");

        map1.put("img", R.mipmap.game2);
        map1.put("title", "第四届亚洲平面设计双年展");
        map1.put("time","官网：http://www.sagdshanghai.org/");
        map1.put("info", "第四届亚洲平面设计双年展+主题“简”，图形设计主题展和自由主题海报……");

        map2.put("img", R.mipmap.game3);
        map2.put("title", "2017伊朗德黑兰国际海报展");
        map2.put("time","投稿邮箱：Posterrorism@gmail.com");
        map2.put("info", "2017丝路精神-西部国际设计双年展，主题“传统工艺的创新设计……");

        map3.put("img", R.mipmap.game4);
        map3.put("title", "2017西部国际设计双年展");
        map3.put("time","投官网：http://www.westdesign.cn/");
        map3.put("info", "2017丝路精神-西部国际设计双年展，主题“传统工艺的创新设计……");

        list.add(map);
        list.add(map1);
        list.add(map2);
        list.add(map3);


        return list;
    }
}
