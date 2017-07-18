package com.rinc.bong.rivatorproject;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by baehyeonbin on 2017. 7. 18..
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    private TextView title;
    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }


    public ViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imageView);
        title = (TextView) itemView.findViewById(R.id.textView);
    }
}
