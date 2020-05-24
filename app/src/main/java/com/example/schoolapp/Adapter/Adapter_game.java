package com.example.schoolapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.schoolapp.R;

import java.util.List;
import java.util.Map;

/**
 * Created by $HL on 2017/8/22.
 */

public class Adapter_game extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Map<String, Object>> data1;
    static class ViewHolder{
        public TextView title;
        public TextView title_context;
        public ImageView news_picture;
        public TextView news_time;
    }

    public Adapter_game(Context context , List<Map<String, Object>> data){
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
        Adapter_game.ViewHolder holder = null;
        if(convertView == null)
        {
            holder = new Adapter_game.ViewHolder();
            //根据自定义的Item布局加载布局
            convertView = inflater.inflate(R.layout.game_item, null);           //实例化
            holder.title = (TextView)convertView.findViewById(R.id.game_title);
            holder.title_context = (TextView)convertView.findViewById(R.id.game_text);
            holder.news_picture = (ImageView) convertView.findViewById(R.id.game_picture);
            holder.news_time = (TextView)convertView.findViewById(R.id.game_time);
            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        }else
        {
            holder = (Adapter_game.ViewHolder)convertView.getTag();
        }
        holder.title.setText(String.valueOf(data1.get(position).get("title")));
        holder.title_context.setText(String.valueOf(data1.get(position).get("info")));
        holder.news_picture.setImageResource((Integer) data1.get(position).get("img"));
        holder.news_time.setText(String.valueOf(data1.get(position).get("time")));
        return convertView;
    }

}
