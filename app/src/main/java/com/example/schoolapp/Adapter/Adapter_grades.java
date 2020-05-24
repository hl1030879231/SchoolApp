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
 * Created by $HL on 2017/8/23.
 */

public class Adapter_grades extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Map<String, Object>> data1;
    static class ViewHolder{
        public TextView course_name;
        public TextView course_grades;
        public TextView teacher_name;
        public TextView credit;
        public TextView point;
    }

    public Adapter_grades(Context context , List<Map<String, Object>> data){
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
        Adapter_grades.ViewHolder holder = null;
        if(convertView == null)
        {
            holder = new Adapter_grades.ViewHolder();
            //根据自定义的Item布局加载布局
            convertView = inflater.inflate(R.layout.gradeslist_item, null);           //实例化
            holder.course_name = (TextView)convertView.findViewById(R.id.course_name);
            holder.course_grades = (TextView)convertView.findViewById(R.id.course_grades);
            holder.teacher_name = (TextView) convertView.findViewById(R.id.teache_name);
            holder.credit = (TextView)convertView.findViewById(R.id.credit);
            holder.point = (TextView)convertView.findViewById(R.id.point);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        }else
        {
            holder = (Adapter_grades.ViewHolder)convertView.getTag();
        }
        holder.course_name.setText(String.valueOf(data1.get(position).get("course_name")));
        holder.course_grades.setText(String.valueOf(data1.get(position).get("course_grades")));
        holder.teacher_name.setText(String.valueOf(data1.get(position).get("teacher_name")));
        holder.credit.setText(String.valueOf(data1.get(position).get("credit")));
        holder.point.setText(String.valueOf(data1.get(position).get("point")));
        return convertView;
    }
}
