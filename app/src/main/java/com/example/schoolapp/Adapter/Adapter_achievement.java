package com.example.schoolapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.schoolapp.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;
import java.util.Map;

/**
 * Created by $HL on 2017/8/23.
 */

public class Adapter_achievement extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Map<String, Object>> data1;
    static class ViewHolder{
        public TextView title_ach;
        public TextView time_ach;
        public TextView reward_ach;
        public RoundedImageView imageView_ach;
    }

    public Adapter_achievement(Context context , List<Map<String, Object>> data){
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
        Adapter_achievement.ViewHolder holder = null;
        if(convertView == null)
        {
            holder = new Adapter_achievement.ViewHolder();
            //根据自定义的Item布局加载布局
            convertView = inflater.inflate(R.layout.achievement_item, null);           //实例化
            holder.title_ach = (TextView)convertView.findViewById(R.id.ach_title);
            holder.time_ach = (TextView)convertView.findViewById(R.id.ach_time);
            holder.reward_ach = (TextView) convertView.findViewById(R.id.ach_reward);
            holder.imageView_ach = (RoundedImageView) convertView.findViewById(R.id.image_ach);

            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        }else
        {
            holder = (Adapter_achievement.ViewHolder)convertView.getTag();
        }
        holder.title_ach.setText(String.valueOf(data1.get(position).get("title")));
        holder.time_ach.setText(String.valueOf(data1.get(position).get("time")));
        holder.reward_ach.setText(String.valueOf(data1.get(position).get("reward")));
        holder.imageView_ach.setImageResource((Integer) data1.get(position).get("imageid"));
        return convertView;
    }
}
