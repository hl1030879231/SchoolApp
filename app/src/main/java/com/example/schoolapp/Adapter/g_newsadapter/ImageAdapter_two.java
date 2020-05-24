package com.example.schoolapp.Adapter.g_newsadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.schoolapp.R;

/**
 * Created by $HL on 2017/8/29.
 */

public class ImageAdapter_two extends BaseAdapter {
    // 定义Context
    private Context context;
    private int[] images = {
            R.mipmap.gnews_two1,
            R.mipmap.gnews_two2,
            R.mipmap.gnews_two3,
            R.mipmap.gnews_two4,
            R.mipmap.gnews_two5,
            R.mipmap.gnews_two6};


    public ImageAdapter_two(Context context) {
        this.context = context;
    }

    // 获取图片个数
    public int getCount() {

        return images.length;
    }

    @Override
    // 获取图片在库中的位置
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView view = new ImageView(context);

        // 给ImageView设置资源
        view.setImageResource(images[position]);

        // 设置布局图片以320*240显示
        view.setLayoutParams(new Gallery.LayoutParams(440, 424));

        // 设置显示比例类型
        view.setScaleType(ImageView.ScaleType.FIT_CENTER);

        return view;
    }
}
