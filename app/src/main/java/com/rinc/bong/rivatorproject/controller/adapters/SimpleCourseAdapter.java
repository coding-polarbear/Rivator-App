package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.SimpleCourse;
import com.rinc.bong.rivatorproject.beans.SimpleTeacher;

import java.util.ArrayList;

/**
 * Created by baehyeonbin on 2017. 8. 5..
 */

public class SimpleCourseAdapter extends ArrayAdapter<SimpleCourse>{
    private ArrayList<SimpleCourse> simpleCourseList;
    private Context context;
    private int resource;
    public SimpleCourseAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<SimpleCourse> simpleCourseList) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.simpleCourseList = simpleCourseList;
    }

    @Override
    public int getCount() {
        return simpleCourseList.size();
    }

    @Override
    public SimpleCourse getItem(int position) {
        return simpleCourseList.get(position);
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
            view = inflater.inflate(resource,null);
        }

        TextView title = view.findViewById(R.id.item_course_title);
        TextView teacherName = view.findViewById(R.id.item_course_teacherName);
        TextView category = view.findViewById(R.id.item_course_category);
        TextView unitTime = view.findViewById(R.id.item_course_unitTime);

        SimpleCourse item = simpleCourseList.get(position);

        title.setText(item.getTitle());
        teacherName.setText(item.getUser().getUserName());
        category.setText(item.getCategory());
        unitTime.setText(Integer.toString(item.getUnitTime())+"시간");

        return view;
    }
}
