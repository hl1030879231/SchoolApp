package com.example.schoolapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
 * Created by $HL on 2017/8/16.
 */

public class Listview_adapter extends RecyclerView.Adapter<Listview_adapter.MyViewHolder>{
    private LayoutInflater inflater;
    private List<Map<String, Object>> data1;
    private Listview_adapter.MyViewHolder.MyItemClickListener mItemClickListener;

    public Listview_adapter(Context context, List<Map<String, Object>> data){
        inflater=LayoutInflater.from(context);
        this.data1 = data;
    }
    //创建每一行的View 用RecyclerView.ViewHolder包装
    @Override
    public Listview_adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        view = inflater.inflate(R.layout.collcetion_listitem, parent, false);
        //通过构造函数将mItemClickListener
      MyViewHolder holder = new MyViewHolder(view, mItemClickListener);
        return holder;
    }
    //给每一行View填充数据
    @Override
    public void onBindViewHolder(Listview_adapter.MyViewHolder holder, int position) {
        holder.itemView.setTag(data1.get(position));
        holder.title.setText(String.valueOf(data1.get(position).get("title")));
        holder.title_context.setText(String.valueOf(data1.get(position).get("info")));
        holder.news_picture.setImageResource((Integer) data1.get(position).get("img"));
        holder.news_time.setText(String.valueOf(data1.get(position).get("time")));
    }
    //数据源的数量
    @Override
    public int getItemCount() {
        return data1.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private TextView title_context;
        private ImageView news_picture;
        private TextView news_time;
        private Listview_adapter.MyViewHolder.MyItemClickListener mListener;


        public MyViewHolder(View itemView, Listview_adapter.MyViewHolder.MyItemClickListener listener) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.collection_title);
            title_context= (TextView) itemView.findViewById(R.id.collection_text);
            news_picture= (ImageView) itemView.findViewById(R.id.collection_picture);
            news_time= (TextView) itemView.findViewById(R.id.collection_time);
            this.mListener = listener;
            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {
//如果mListener不为空，就实现接口中的方法onItemClick其中getPosition()是得到被点击位置的position
            if (mListener != null) {
                mListener.onItemClick(v, getPosition());
            }
        }

        //声明MyItemClickListener这个接口
        public interface MyItemClickListener {
            public void onItemClick(View view, int postion);
        }
    }


    /**
     * 设置Item点击监听
     *
     * @param listener
     */
    public void setOnItemClickListener(Listview_adapter.MyViewHolder.MyItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    }




