package com.example.schoolapp.Activity.student;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.schoolapp.Adapter.Adapter_grades;
import com.example.schoolapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by $HL on 2017/8/22.
 */

public class Activity_grades extends AppCompatActivity {
    private LinearLayout title_l;
    private TextView text_c;
    private Spinner spinner_data;
    private Spinner spinner_term;
    private ListView listview_grades;
    private Adapter_grades adapter_grades;
    private List<Map<String, Object>> data;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        showspinner();
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
        text_c.setText("学生成绩");
    }

    public void showspinner(){
        spinner_data = (Spinner)findViewById(R.id.spinner_data);
        spinner_term = (Spinner)findViewById(R.id.spinner_term);
        String[] data_list = new String[]{"2014-2015","2015-2016","2016-2017","2017-2018","2018-2019","2019-2020"};
        String[] term_list = new String[]{"1","2"};
        ArrayAdapter<String> adapter_data=new ArrayAdapter<String>(this,R.layout.myspinner, data_list);
        ArrayAdapter<String> adapter_term=new ArrayAdapter<String>(this,R.layout.myspinner,term_list);
        adapter_data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_term.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_data.setAdapter(adapter_data);
        spinner_term.setAdapter(adapter_term);
    }

    public void showlist(){
        listview_grades = (ListView)findViewById(R.id.listview_grades);
        data = getData();
        adapter_grades = new Adapter_grades(this,data);
        listview_grades.setAdapter(adapter_grades);
        adapter_grades.notifyDataSetChanged();
    }


    private List<Map<String, Object>> getData()
    {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
       Map<String, Object> map;
        Map<String, Object> map1;
        Map<String, Object> map2;
        Map<String, Object> map3;
        Map<String, Object> map4;
        Map<String, Object> map5;
        Map<String, Object> map6;
        Map<String, Object> map7;
        Map<String, Object> map8;
        Map<String, Object> map9;
        Map<String, Object> map10;
        Map<String, Object> map11;
        map = new HashMap<String, Object>();
        map1 = new HashMap<String, Object>();
        map2 = new HashMap<String, Object>();
        map3 = new HashMap<String, Object>();
        map4 = new HashMap<String, Object>();
        map5 = new HashMap<String, Object>();
        map6 = new HashMap<String, Object>();
        map7 = new HashMap<String, Object>();
        map8 = new HashMap<String, Object>();
        map9 = new HashMap<String, Object>();
        map10 = new HashMap<String, Object>();
        map11 = new HashMap<String, Object>();



        map.put("course_name", "色彩设计");
        map.put("course_grades", "94");
        map.put("teacher_name","马良");
        map.put("credit", "2");
        map.put("point", "4.4");


        map1.put("course_name", "大学英语");
        map1.put("course_grades", "98");
        map1.put("teacher_name","李白");
        map1.put("credit", "4");
        map1.put("point", "4.8");

        map2.put("course_name", "服装设计");
        map2.put("course_grades", "90");
        map2.put("teacher_name","莫里");
        map2.put("credit", "2");
        map2.put("point", "4.0");

        map3.put("course_name", "设计造型");
        map3.put("course_grades", "92");
        map3.put("teacher_name","毕加");
        map3.put("credit", "2");
        map3.put("point", "4.2");

        map4.put("course_name", "中国近代史");
        map4.put("course_grades", "88");
        map4.put("teacher_name","司马一");
        map4.put("credit", "4");
        map4.put("point", "3.8");

        map5.put("course_name", "体育（二）");
        map5.put("course_grades", "90");
        map5.put("teacher_name","姚翔");
        map5.put("credit", "2");
        map5.put("point", "4.0");

        map6.put("course_name", "标识与企业形象");
        map6.put("course_grades", "91");
        map6.put("teacher_name","稼轩");
        map6.put("credit", "4");
        map6.put("point", "4.0");

        map7.put("course_name", "信息设计");
        map7.put("course_grades", "94");
        map7.put("teacher_name","伦勃");
        map7.put("credit", "4");
        map7.put("point", "4.4");

        map8.put("course_name", "印刷工艺与设计");
        map8.put("course_grades", "96");
        map8.put("teacher_name","司徒二");
        map8.put("credit", "4");
        map8.put("point", "4.4");

        map9.put("course_name", "市场营销学");
        map9.put("course_grades", "88");
        map9.put("teacher_name","江来");
        map9.put("credit", "2");
        map9.put("point", "3.8");

        map10.put("course_name", "公共关系学");
        map10.put("course_grades", "90");
        map10.put("teacher_name","张珂");
        map10.put("credit", "2");
        map10.put("point", "4.0");



        list.add(map);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        list.add(map6);
        list.add(map7);
        list.add(map8);
        list.add(map9);
        list.add(map10);

        return list;
    }
}
