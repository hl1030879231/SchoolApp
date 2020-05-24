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

public class Adapter_corporation extends BaseAdapter {
    private LayoutInflater inflater;
    private List<Map<String, Object>> data1;
    static class ViewHolder{
        public TextView cor_name;
        public TextView cor_style;
        public TextView cor_details;
        public RoundedImageView cor_image;
    }

    public Adapter_corporation(Context context , List<Map<String, Object>> data){
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
        Adapter_corporation.ViewHolder holder = null;
        if(convertView == null)
        {
            holder = new Adapter_corporation.ViewHolder();
            //根据自定义的Item布局加载布局
            convertView = inflater.inflate(R.layout.corporation_item, null);           //实例化
            holder.cor_name = (TextView)convertView.findViewById(R.id.cor_name);
            holder.cor_style = (TextView)convertView.findViewById(R.id.cor_style);
            holder.cor_details = (TextView) convertView.findViewById(R.id.cor_details);
            holder.cor_image = (RoundedImageView) convertView.findViewById(R.id.image_cor);

            //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag
            convertView.setTag(holder);
        }else
        {
            holder = (Adapter_corporation.ViewHolder)convertView.getTag();
        }
        holder.cor_name.setText(String.valueOf(data1.get(position).get("name")));
        holder.cor_style.setText(String.valueOf(data1.get(position).get("style")));
        holder.cor_details.setText(String.valueOf(data1.get(position).get("details")));
        holder.cor_image.setImageResource((Integer) data1.get(position).get("imageid"));
        return convertView;
    }
}
