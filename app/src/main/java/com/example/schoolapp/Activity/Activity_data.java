package com.example.schoolapp.Activity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.schoolapp.Adapter.Adapter_listdata;
import com.example.schoolapp.R;
import com.example.schoolapp.SQLite.HoursDB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by $HL on 2017/8/19.
 */

public class Activity_data extends AppCompatActivity {
    private LinearLayout title_l;
    private TextView text_c;
    private ListView list_data;
    private ListView list_data_must;
    private Adapter_listdata adapter_listdata;
    private Button add_b;
    private TextView else_data;
    private LinearLayout add_m;
    private TextView hours_date;
    private EditText hours_context;
    private Button commit;
    private ImageView image_date;
    private int start_y;
    private int start_m ;
    private int start_d;
    private String item_date;
    private String hours_dates;
    private String hours_contexts;
    private HoursDB Hoursdb;  //数据库帮助类
    private ArrayList<HashMap<String, Object>> listData; //  key-value
    private ArrayList<String>  listdata_m;
    private String[] else_time = new String[20];
    private int j = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Hoursdb = new HoursDB(Activity_data.this, "hours", 2);       //创建一个名为“hours”的数据库
        init();
        showlist();
    }

    public void init(){
        title_l = (LinearLayout)findViewById(R.id.title_l);
        text_c = (TextView)findViewById(R.id.text_c);
        add_b = (Button)findViewById(R.id.add);
        add_m = (LinearLayout)findViewById(R.id.add_m);
        else_data = (TextView)findViewById(R.id.else_day);
        hours_context = (EditText)findViewById(R.id.hours_context) ;
        hours_date = (TextView)findViewById(R.id.hours_date) ;
        image_date = (ImageView)findViewById(R.id.image_date);
        commit = (Button)findViewById(R.id.commit);
        title_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        text_c.setText("提醒日期设置");
    }

    public void showlist(){
        list_data = (ListView)findViewById(R.id.data_list);
        list_data_must = (ListView)findViewById(R.id.data_list_must);

        adapter_listdata = new Adapter_listdata(this);

        list_data_must.setAdapter(adapter_listdata);
        adapter_listdata.notifyDataSetChanged();
        Cursor cursor = Hoursdb.getReadableDatabase().rawQuery("select * from time_table", null);
        inflateListView(cursor);      //刷新listview
        list_data.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(Activity_data.this)
                        // 弹出窗口的最上头文字
                        .setTitle("删除当前数据")
                        //设置弹出窗口的图式
                        .setIcon(android.R.drawable.ic_dialog_info)
                        // 设置弹出窗口的信息
                        .setMessage("确定删除当前记录")
                        .setPositiveButton("是",
                                new DialogInterface.OnClickListener() {
                                    public void onClick( DialogInterface dialoginterface, int i) {
                                        // 获取位置索引
                                        // 将listview中所有的数据都传入hashmap-listData中
                                        Cursor c = Hoursdb.getReadableDatabase().rawQuery("select * from time_table", null);
                                        int columnsSize = c.getColumnCount();
                                        listData = new ArrayList<HashMap<String, Object>>();
                                        while (c.moveToNext()) {
                                            HashMap<String, Object> map = new HashMap<String, Object>();
                                            for (int j = 0; j < columnsSize; j++) {
                                                map.put("_id", c.getString(0));
                                                map.put("news_tittle", c.getString(1));
                                                map.put("news_content", c.getString(2));
                                                map.put("news_else", c.getString(3));
                                            }
                                            listData.add(map);
                                        }
                                        HashMap<String, Object> map = listData .get(position);
                                        // 获取id
                                        int id = Integer.valueOf((map.get("_id").toString()));
                                        deleteNews(id);
                                        // 移除数据
                                    }
                                }
                        )
                        .setNegativeButton("否",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(
                                            DialogInterface dialoginterface, int i) {
                                        // 什么也没做

                                    }
                                }).show();
                return true;
            }
        });

        image_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                // 直接创建一个DatePickerDialog对话框实例，并将它显示出来
                new DatePickerDialog(Activity_data.this,
                        // 绑定监听器
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                start_y = year;
                                start_m = monthOfYear + 1;
                                start_d = dayOfMonth;
                                hours_date.setText(start_y + "-" + start_m + "-" + start_d );

                            }
                        },
                        // 设置初始日期
                        c.get(Calendar.YEAR), c.get(Calendar.MONTH), c
                        .get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        add_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_b.setVisibility(View.GONE);
                add_m.setVisibility(View.VISIBLE);
            }
        });

        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hours_dates = hours_date.getText().toString();
                hours_contexts = hours_context.getText().toString();
                if(!TextUtils.isEmpty(hours_contexts) && !TextUtils.isEmpty(hours_dates)){
                    insertNews();
                    add_b.setVisibility(View.VISIBLE);
                    add_m.setVisibility(View.GONE);
                }
                else if (TextUtils.isEmpty(hours_contexts)){
                    Toast.makeText(Activity_data.this,"事件名称未填写!",Toast.LENGTH_SHORT).show();
                }
                else if (TextUtils.isEmpty(hours_dates)){
                    Toast.makeText(Activity_data.this,"时间未选择!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /*
* 刷新数据库列表显示
* 1. 关联SimpleCursorAdapter与数据库表, 获取数据库表中的最新数据
* 2. 将最新的SimpleCursorAdapter设置给ListView
*/
    private void inflateListView(Cursor cursor) {
        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.data_item, cursor,
                new String[]{"news_tittle", "news_content", "news_else"}, new int[]{R.id.data_name, R.id.data_all
        ,R.id.else_day},2);
     /*   for(int i = 0;i<j;i++){
            else_data.setText(else_time[i]);
        }*/
        cursorAdapter.notifyDataSetChanged();
        list_data.setAdapter(cursorAdapter);
    }


    /*
* 删除新闻数据
* 根据_id删除指定数据，并进行刷新
*/
    private boolean deleteNews(int _id) {
        String whereClause = "_id=?";
        String[] whereArgs = new String[] { String.valueOf(_id) };
        try{
            Hoursdb.getReadableDatabase().delete("time_table", whereClause,whereArgs);
            Cursor cursor = Hoursdb.getWritableDatabase().rawQuery("select * from time_table", null);
            inflateListView(cursor);
        }catch (SQLException e) {
            Toast.makeText(Activity_data.this, "删除数据库失败",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


    /*
* 插入新闻数据
* 1. 从EditText组件中获取新闻的标题 和 新闻内容
* 2. 获取数据库并从将 新闻标题 和 内容 插入到数据库中
* 3. 重新查询数据库 获得Cursor对象
* 4. 根据cursor对象创建SimpleCursorAdapter对象
* 5. 将SimpleCursorAdapter设置给ListView, 显示新闻列表
*/
    private void insertNews() {
        String tittle = hours_context.getText().toString();//名称
        String content = hours_date.getText().toString();//日期
        java.util.Calendar now = java.util.Calendar.getInstance();
        int year_now = now.get(java.util.Calendar.YEAR);
        int month_now = now.get(java.util.Calendar.MONTH) + 1;
        int day_now = now.get(java.util.Calendar.DAY_OF_MONTH);
        String[] datearray = content.split("-");
        int year = Integer.valueOf(datearray[0]);
        int month = Integer.valueOf(datearray[1]);
        int day = Integer.valueOf(datearray[2]);
        int daynum = (year - year_now)*365 + (month - month_now)*30 + (day - day_now);
        else_time[j] = String.valueOf(daynum);
        Hoursdb.getReadableDatabase().execSQL("insert into time_table values(null, ?, ? ,?)", new String[]{tittle, content
        ,String.valueOf(daynum)});

        Cursor cursor = Hoursdb.getReadableDatabase().rawQuery("select * from time_table", null);
        inflateListView(cursor);      //刷新listview
    }



}
