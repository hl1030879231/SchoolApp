package com.example.schoolapp.Adapter.g_newsadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.example.schoolapp.R;

/**
 * Created by 帅气的靓仔 on 2017/9/8.
 */

public class ImageAdapter_four extends BaseAdapter {
    // 定义Context
    private Context context;
    private int[] images = {
            R.mipmap.gnews_four1,
            R.mipmap.gnews_four2,
            R.mipmap.gnews_four3,
            R.mipmap.gnews_four4,
            R.mipmap.gnews_four5,
            R.mipmap.gnews_four6};


    public ImageAdapter_four(Context context) {
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
