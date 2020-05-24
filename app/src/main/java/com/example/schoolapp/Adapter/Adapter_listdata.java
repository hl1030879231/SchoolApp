package com.example.schoolapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.schoolapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by $HL on 2017/9/15.
 */

public class Adapter_listdata extends BaseAdapter {
    private LayoutInflater inflater;
  /*  private String[] data1_t = new String[]{
           "距离四六级考试还有","元旦节","您孩子的生日"
    }
    private  String[] data1_all = new  String[]{
        "2017-9-22","2017-9-20","2017-11-1"
    }
    private  String[] data1_else = new String[]{
        "116","101","16"
    }*/

  private String[] data1_t = new String[]{
          "距离四六级考试","距离元旦节","距离您孩子生日"
  };

    private  String[] data1_all = new  String[]{
            "2017-9-22","2017-9-20","2017-11-1"
    };

    private  String[] data1_else = new String[]{
            "116","101","16"
    };



    static class ViewHolder{
        public TextView title;
        public TextView data_all;
        public TextView else_day_m;
    }

    public Adapter_listdata(Context context){
        this.inflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return data1_all.length;
    }

    @Override
    public Object getItem(int position) {
        return data1_all[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Adapter_listdata.ViewHolder holder = null;
        if(convertView == null)
        {
            holder = new Adapter_listdata.ViewHolder();
            //根据自定义的Item布局加载布局
            convertView = inflater.inflate(R.layout.listdata_item, null);           //实例化
            holder.title = (TextView)convertView.findViewById(R.id.data_name_m);
            holder.data_all = (TextView)convertView.findViewById(R.id.data_all_m);
            holder.else_day_m = (TextView) convertView.findViewById(R.id.else_day_m);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        }else
        {
            holder = (Adapter_listdata.ViewHolder)convertView.getTag();
        }
        holder.title.setText(String.valueOf(data1_t[position]));
        holder.data_all.setText(String.valueOf(data1_all[position]));
        holder.else_day_m.setText(String.valueOf(data1_else[position]));
        return convertView;
    }

}
