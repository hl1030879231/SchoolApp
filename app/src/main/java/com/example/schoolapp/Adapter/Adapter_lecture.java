package com.example.schoolapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.schoolapp.R;

import java.util.List;
import java.util.Map;

/**
 * Created by $HL on 2017/8/22.
 */

public class Adapter_lecture extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Map<String, Object>> data1;
    static class ViewHolder{
        public TextView title_lecture;
        public TextView time_lecture;
        public TextView where_lecture;
        public TextView host_lecture;
    }

    public Adapter_lecture(Context context , List<Map<String, Object>> data){
        this.inflater= LayoutInflater.from(context);
        this.data1 = data;
    }

    @Override
    public int getCount() {
        return data1.size();
    }

    @Override
    public Object getItem(int position) {
        return data1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Adapter_lecture.ViewHolder holder = null;
        if(convertView == null)
        {
            holder = new Adapter_lecture.ViewHolder();
            //根据自定义的Item布局加载布局
            convertView = inflater.inflate(R.layout.lecture_item, null);           //实例化
            holder.title_lecture = (TextView)convertView.findViewById(R.id.lectute_title);
            holder.time_lecture = (TextView)convertView.findViewById(R.id.lectureitem_time);
            holder.where_lecture = (TextView) convertView.findViewById(R.id.lectureitem_where);
            holder.host_lecture = (TextView)convertView.findViewById(R.id.lectureitem_host);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        }else
        {
            holder = (Adapter_lecture.ViewHolder)convertView.getTag();
        }
        holder.title_lecture.setText(String.valueOf(data1.get(position).get("title")));
        holder.time_lecture.setText(String.valueOf(data1.get(position).get("time")));
        holder.where_lecture.setText(String.valueOf(data1.get(position).get("where")));
        holder.host_lecture.setText(String.valueOf(data1.get(position).get("host")));
        return convertView;
    }
}
