package com.example.schoolapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.schoolapp.Activity.g_news.Activity_gnewsdetailsthree;
import com.example.schoolapp.Activity.g_news.Activity_gnewsdetailstwo;
import com.example.schoolapp.Adapter.Adapter_search;
import com.example.schoolapp.Adapter.FilterListener;
import com.example.schoolapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 帅气的靓仔 on 2017/9/7.
 */

public class Activity_search extends AppCompatActivity {
    private EditText ed_search;
    private ListView lv_search;
    private GridView grid_search;
    private LinearLayout search_back;
    private List<String> list = new ArrayList<String>();
    boolean isFilter;
    private TextView clear;
    private Adapter_search adapter_search = null;
    private String key;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setViews();// 控件初始化
        setData();// 给listView设置adapter
        setListeners();// 设置监听
    }

    /**
     * 控件初始化
     */
    private void setViews() {
        ed_search = (EditText) findViewById(R.id.search);// EditText控件
       /* lv_search = (ListView)findViewById(R.id.lv_search);// ListView控件*/
        clear = (TextView)findViewById(R.id.clear);//清除控件
        grid_search = (GridView)findViewById(R.id.grid_serach);
        search_back = (LinearLayout)findViewById(R.id.search_back);
        search_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed_search.setText("");
            }
        });
    }


    /**
     * 数据初始化并设置adapter
     */
    private void setData() {
        initData();// 初始化数据

        // 这里创建adapter的时候，构造方法参数传了一个接口对象，这很关键，回调接口中的方法来实现对过滤后的数据的获取
        adapter_search = new Adapter_search(list, this, new FilterListener() {
            // 回调方法获取过滤后的数据
            public void getFilterData(List<String> list) {
                // 这里可以拿到过滤后数据，所以在这里可以对搜索后的数据进行操作
                Log.e("TAG", "接口回调成功");
                Log.e("TAG", list.toString());
                setItemClick(list);
            }
        });
        grid_search.setAdapter(adapter_search);
    }


    /**
     * 给listView添加item的单击事件
     * @param filter_lists  过滤后的数据集
     */
    protected void setItemClick(final List<String> filter_lists) {
        grid_search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // 点击对应的item时，弹出toast提示所点击的内容
               if(position == 0){
                   key = "zero";
                   Intent intent = new Intent();
                   intent.setClass(Activity_search.this,Activity_newsdetails.class);
                   intent.putExtra("key",key);
                   startActivity(intent);
               }
               else if(position ==1 )
               {
                   key = "one";
                   Intent intent = new Intent();
                   intent.setClass(Activity_search.this, Activity_newsdetails.class);
                   intent.putExtra("key",key);
                   startActivity(intent);
               }
               else if(position ==2 )
               {
                   key = "two";
                   Intent intent = new Intent();
                   intent.setClass(Activity_search.this, Activity_newsdetails.class);
                   intent.putExtra("key",key);
                   startActivity(intent);
               }
               else if(position ==3 )
               {
                   key = "three";
                   Intent intent = new Intent();
                   intent.setClass(Activity_search.this, Activity_newsdetails.class);
                   intent.putExtra("key",key);
                   startActivity(intent);
               }
               else if(position ==4)
               {
                   key = "one";
                   Intent intent = new Intent();
                   intent.setClass(Activity_search.this, Activity_gnewsdetailstwo.class);
                   intent.putExtra("key_g",key);
                   startActivity(intent);
               }
               else if(position ==5 )
               {
                   key = "four";
                   Intent intent = new Intent();
                   intent.setClass(Activity_search.this, Activity_gnewsdetailsthree.class);
                   intent.putExtra("key_g",key);
                   startActivity(intent);
               }
            }
        });
    }

    /**
     * 简单的list集合添加一些测试数据
     */
    private void initData() {
        list.add("毕业季，A大学子书雄章");
        list.add("新生开学指南及注意事项");
        list.add("新生军训指南");
        list.add("新生开学典礼");
        list.add("李副校长访问菲律宾");
        list.add("科技成果展示会");
    }

    private void setListeners() {
        // 没有进行搜索的时候，也要添加对listView的item单击监听
        setItemClick(list);

        /**
         * 对编辑框添加文本改变监听，搜索的具体功能在这里实现
         * 很简单，文本该变的时候进行搜索。关键方法是重写的onTextChanged（）方法。
         */
        ed_search.addTextChangedListener(new TextWatcher() {

            /**
             *
             * 编辑框内容改变的时候会执行该方法
             */
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // 如果adapter不为空的话就根据编辑框中的内容来过滤数据
                if(adapter_search != null){
                    adapter_search.getFilter().filter(s);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
    }

}
