package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.CourseReview;
import com.rinc.bong.rivatorproject.beans.SimpleTeacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baehy on 2017. 9. 23..
 */

public class CourseReviewAdapter extends ArrayAdapter<CourseReview> {
    private List<CourseReview> listViewItem = new ArrayList<CourseReview>();
    private Context context;
    private int srsc;

    public CourseReviewAdapter(Context context, int srsc, List<CourseReview> items) {
        super(context,srsc,items);
        this.context = context;
        this.srsc = srsc;
        this.listViewItem = items;
    }
    @Override
    public int getCount() {
        return listViewItem.size();
    }

    @Override
    public CourseReview getItem(int position) {
        return listViewItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        View view = convertView;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(srsc,null);
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView subject = (TextView) view.findViewById(R.id.category);
        TextView score = (TextView) view.findViewById(R.id.score);

        CourseReview item = listViewItem.get(position);
        name.setText(item.getUser().getUserName());
        score.setText(Double.toString(item.getScore()));
        if(item.getContent().length() > 10)
            subject.setText(item.getContent().substring(0,10) + "...");
        else
            subject.setText(item.getContent());
        return view;
    }
}
