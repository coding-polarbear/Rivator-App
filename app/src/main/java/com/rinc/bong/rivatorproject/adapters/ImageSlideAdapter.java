package com.rinc.bong.rivatorproject.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by bong on 2017-07-23.
 */

public class ImageSlideAdapter extends PagerAdapter {

    private Context context = null;
    private String[] imageUri = null;


    public ImageSlideAdapter(Context context, String[] imageUri) {
        this.context = context;
        this.imageUri = imageUri;
    }

    @Override
    public int getCount() {
        return imageUri.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int i) {

        ImageView mImageView = new ImageView(context);
        Glide.with(context).load(imageUri[i]).into(mImageView);
        container.addView(mImageView, 0);
        return mImageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
        container.removeView((ImageView) obj);
    }
}
