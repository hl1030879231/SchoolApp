package com.example.schoolapp.Activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/9/11.
 */

public class Activity_identity extends AppCompatActivity {
    private Button commit_id;
    private Spinner spinner_pro;
    private Spinner spinner_city;
    private Spinner spinner_school;
    ArrayAdapter<String> provinceAdapter = null;  //省级适配器
    ArrayAdapter<String> cityAdapter = null;    //地级适配器
    ArrayAdapter<String> schoolAdapter = null;    //县级适配器
    static int provincePosition = 3;
    private EditText par_name;
    private EditText child_name;
    private EditText id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identity);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        work();
        showspinner();
    }

    public void init() {
        commit_id = (Button) findViewById(R.id.commit_id);
        spinner_pro = (Spinner)findViewById(R.id.spinner_pro);
        spinner_city = (Spinner)findViewById(R.id.spinner_city);
        spinner_school = (Spinner)findViewById(R.id.spinner_school);
        par_name = (EditText)findViewById(R.id.par_name);
        child_name = (EditText)findViewById(R.id.child_name);
        id = (EditText)findViewById(R.id.id);
    }

    public void work() {
        commit_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_par = String.valueOf(par_name.getText());
                String name_child = String.valueOf(child_name.getText());
                String id_text = String.valueOf(id.getText());
                if (!TextUtils.isEmpty(name_child) && !TextUtils.isEmpty(name_par) && !TextUtils.isEmpty(id_text)) {
                    Intent intent = new Intent();
                    intent.setClass(Activity_identity.this, Activity_waitrespon.class);
                    startActivity(intent);
                    Activity_identity.this.finish();
                }
                else if(TextUtils.isEmpty(name_child)){
                    Toast.makeText(Activity_identity.this,"学生姓名未填写！",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(name_par)){
                    Toast.makeText(Activity_identity.this,"父母姓名未填写！",Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(id_text)){
                    Toast.makeText(Activity_identity.this,"身份证号未填写！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showspinner(){
        String[] pro_list = new String[]{"浙江省","河北省","河南省","广州省","江苏省","北京市","上海市"};
        final String[][] city_list = new String[][]{
                {"杭州市","临安市","宁波市","温州市","嘉兴市","湖州市","绍兴市"},
                {"石家庄市","唐山市","邯郸市","张家口市","衡水市"},
                {"郑州市","开封市","洛阳市","焦作市","南阳市"},
                {"广州市","深圳市","珠海市","汕头市","东莞市"},
                {"南京市","徐州市","苏州市","扬州市","无锡市"},
                {"西城区","朝阳区","海淀区","东城区"},
                {"徐汇区","虹口区","嘉定区","浦东新区"}};
        final String[][][] school_list = new String[][][]{
                {   //浙江
                        {"浙江A大学", "浙江B大学", "浙江C大学", "浙江D大学", "浙江E大学"},
                        {"浙江A大学"},
                        {"浙江A大学", "浙江B大学", "浙江C大学", "浙江D大学"},
                        {"浙江A大学", "浙江B大学"},
                        {"浙江A大学"},
                        {"浙江A大学"},
                        {"浙江A大学"}
                },
                {    //河北
                        {"河北A大学"," 河北B大学"},
                        {"河北A大学","河北B大学"},
                        {"河北A大学"},
                        {"河北A大学"},
                        {"河北A大学"}
                },
                {    //河南
                        {"河南A大学","河南A大学","河南A大学"},
                        {"河南A大学","河南A大学"},
                        {"河南A大学"},
                        {"河南A大学"},
                        {"河南A大学","河南A大学"}
                },
                {    //广州
                        {"广州A大学"}, //广州
                        {"广州A大学"}, //深圳
                        {"广州A大学", "广州A大学"},  //韶关
                        {"广州A大学", "广州A大学"},  //韶关
                        {"广州A大学", "广州A大学", "广州A大学"}  //韶关
                },
                {    //江苏
                        {"江苏B大学", "江苏C大学", "江苏D大学", "江苏V大学"}, //广州
                        {"江苏A大学", "江苏B大学"}, //深圳
                        {"江苏A大学", "江苏B大学"},  //韶关
                        {"江苏A大学"},  //韶关
                },
                {    //北京
                        {"北京A大学", "北京B大学"}, //广州
                        {"北京A大学 ", "北京B大学 ", "北京c大学 "}, //深圳
                        {"北京A大学", "北京B大学", "北京C大学", "北京D大学", "北京E大学"},  //韶关
                        {"北京A大学"},  //韶关
                },
                {    //北京
                        {"上海A大学", "上海B大学","上海C大学"}, //广州
                        {"上海A大学 ", "上海B大学 "}, //深圳
                        {"上海A大学", "上海B大学", "上海C大学"},  //韶关
                        {"上海A大学","上海B大学"},  //韶关
                }};

   /*     //省级选项值
        final String[] pro_list = new String[] {"北京","上海","天津","广东"};//,"重庆","黑龙江","江苏","山东","浙江","香港","澳门"};
        //地级选项值
        final String[][] city_list = new String[][]
                {
                        { "东城区", "西城区", "崇文区", "宣武区", "朝阳区", "海淀区", "丰台区", "石景山区", "门头沟区",
                                "房山区", "通州区", "顺义区", "大兴区", "昌平区", "平谷区", "怀柔区", "密云县",
                                "延庆县" },
                        { "长宁区", "静安区", "普陀区", "闸北区", "虹口区" },
                        { "和平区", "河东区", "河西区", "南开区", "河北区", "红桥区", "塘沽区", "汉沽区", "大港区",
                                "东丽区" },
                        { "广州", "深圳", "韶关" // ,"珠海","汕头","佛山","湛江","肇庆","江门","茂名","惠州","梅州",
                                // "汕尾","河源","阳江","清远","东莞","中山","潮州","揭阳","云浮"
                        }
                };

        //县级选项值
        final String[][][] school_list = new String[][][]
                {
                        {   //北京
                                {"无1"},{"无2"},{"无3"},{"无4"},{"无5"},{"无6"},{"无7"},{"无8"},{"无9"},{"无10"},
                                {"无11"},{"无12"},{"无13"},{"无14"},{"无15"},{"无16"},{"无17"},{"无18"}
                        },
                        {    //上海
                                {"无21"},{"无22"},{"无23"},{"无24"},{"无25"}
                        },
                        {    //天津
                                {"无31"},{"无32"},{"无33"},{"无34"},{"无35"},{"无36"},{"无37"},{"无38"},{"无39"},{"无40"}
                        },
                        {    //广东
                                {"海珠区","荔湾区","越秀区","白云区","萝岗区","天河区","黄埔区","花都区","从化市","增城市","番禺区","南沙区"}, //广州
                                {"宝安区","福田区","龙岗区","罗湖区","南山区","盐田区"}, //深圳
                                {"武江区","浈江区","曲江区","乐昌市","南雄市","始兴县","仁化县","翁源县","新丰县","乳源县"}  //韶关
                        }
                };*/

        //绑定适配器和值
        provinceAdapter = new ArrayAdapter<String>(Activity_identity.this,
                R.layout.myspinner, pro_list);
        spinner_pro.setAdapter(provinceAdapter);

        cityAdapter = new ArrayAdapter<String>(Activity_identity.this,
                R.layout.myspinner2, city_list[3]);
        spinner_city.setAdapter(cityAdapter);

        schoolAdapter = new ArrayAdapter<String>(Activity_identity.this,
                R.layout.myspinner3, school_list[3][0]);
        spinner_school.setAdapter(schoolAdapter);

        provinceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        schoolAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner_pro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            // 表示选项被改变的时候触发此方法，主要实现办法：动态改变地级适配器的绑定值
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3)
            {
                //position为当前省级选中的值的序号

                //将地级适配器的值改变为city[position]中的值
                cityAdapter = new ArrayAdapter<String>(
                        Activity_identity.this,R.layout.myspinner2, city_list[position]);
                // 设置二级下拉列表的选项内容适配器
                spinner_city.setAdapter(cityAdapter);
                provincePosition = position;    //记录当前省级序号，留给下面修改县级适配器时用
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {

            }

        });


        //地级下拉监听
        spinner_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long arg3)
            {
                schoolAdapter = new ArrayAdapter<String>(Activity_identity.this,
                        R.layout.myspinner2, school_list[provincePosition][position]);
                spinner_school.setAdapter(schoolAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {

            }
        });
    }
}
