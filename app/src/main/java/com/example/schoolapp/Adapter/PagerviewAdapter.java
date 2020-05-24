package com.example.schoolapp.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.schoolapp.R;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

/**
 * Created by $HL on 2017/5/8.
 */

public class PagerviewAdapter extends StaticPagerAdapter {
    private int[] imgs = {
            R.drawable.groview_one,
            R.drawable.groview_two,
            R.drawable.groview_three,
            R.drawable.groview_four,
    };
    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setImageResource(imgs[position]);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    public int getCount() {
        return imgs.length;
    }
}
