package com.example.schoolapp.Activity.personal;

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

import com.example.schoolapp.Activity.Activity_collectiondetails;
import com.example.schoolapp.Activity.g_news.Activity_gnewsdetailsone;
import com.example.schoolapp.Adapter.Listview_adapter;
import com.example.schoolapp.Adapter.Recycleview_adapter;
import com.example.schoolapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by $HL on 2017/8/15.
 */

public class Activity_collection extends AppCompatActivity {
    private RecyclerView listView;
    private Listview_adapter listview_adapter;
    private List<Map<String, Object>> data;
    private LinearLayout title_l;
    private TextView text_c;
    String key_g;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collrction_activity);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    public void init(){
        data = getData();
        listView = (RecyclerView)findViewById(R.id.collection_list);
        title_l = (LinearLayout)findViewById(R.id.title_l);
        text_c = (TextView)findViewById(R.id.text_c);
        title_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        listView.setLayoutManager(new LinearLayoutManager(this));//设置布局管理器
       /* recyclerView.addItemDecoration(new DividerItemDecoration(this));*/
        listView.setAdapter(listview_adapter=new Listview_adapter(this,data));
        text_c.setText("我的收藏");
       /* listview_adapter = new Listview_adapter(this,data);
        listView.setAdapter(listview_adapter);
        listview_adapter.notifyDataSetChanged();*/

       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0 ){
                    key_g = "one";
                    Intent intent = new Intent();
                    intent.setClass(Activity_collection.this, Activity_collectiondetails.class);
                    intent.putExtra("key_g",key_g);
                    startActivity(intent);
                }
                else if(i == 1 ){
                    key_g = "two";
                    Intent intent = new Intent();
                    intent.setClass(Activity_collection.this, Activity_collectiondetails.class);
                    intent.putExtra("key_g",key_g);
                    startActivity(intent);
                }
                else if(i == 2 ){
                    key_g = "three";
                    Intent intent = new Intent();
                    intent.setClass(Activity_collection.this, Activity_collectiondetails.class);
                    intent.putExtra("key_g",key_g);
                    startActivity(intent);
                }
            }
        });
        */

       listview_adapter.setOnItemClickListener(new Listview_adapter.MyViewHolder.MyItemClickListener(){
           public void onItemClick(View view, int postion){
               if(postion == 0 ){
                   key_g = "one";
                   Intent intent = new Intent();
                   intent.setClass(Activity_collection.this, Activity_collectiondetails.class);
                   intent.putExtra("key_g",key_g);
                   startActivity(intent);
               }
               else if(postion == 1 ){
                   key_g = "two";
                   Intent intent = new Intent();
                   intent.setClass(Activity_collection.this, Activity_collectiondetails.class);
                   intent.putExtra("key_g",key_g);
                   startActivity(intent);
               }
               else if(postion == 2 ){
                   key_g = "three";
                   Intent intent = new Intent();
                   intent.setClass(Activity_collection.this, Activity_collectiondetails.class);
                   intent.putExtra("key_g",key_g);
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

        map.put("img", R.mipmap.gnews_two1);
        map.put("title", "李校长访问菲律宾大学");
        map.put("time", "2017.5.7");
        map.put("info", "李副校长一行访问菲律宾亚典耀大学……");

        map1.put("img", R.mipmap.gnews_two2);
        map1.put("title", "会见法国大区主席");
        map1.put("time", "2017.4.15");
        map1.put("info", "李萍副书记会见法国普罗旺斯大区主席一行……");

        map2.put("img", R.mipmap.gnews_two4);
        map2.put("title", "韩国高丽大学校长来访");
        map2.put("time", "2017.4.15");
        map2.put("info", "韩国高丽大学校长访问我校，朱熹平副校长接见……");

        list.add(map);
        list.add(map1);
        list.add(map2);

        return list;
    }
}
