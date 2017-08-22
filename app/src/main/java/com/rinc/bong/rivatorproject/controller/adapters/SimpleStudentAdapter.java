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
import com.rinc.bong.rivatorproject.beans.SimpleStudent;
import com.rinc.bong.rivatorproject.beans.SimpleTeacher;

import java.util.ArrayList;

/**
 * Created by baehyeonbin on 2017. 8. 19..
 */

public class SimpleStudentAdapter extends ArrayAdapter {
    private ArrayList<SimpleStudent> listViewItem = new ArrayList<SimpleStudent>();
    private Context context;
    private int srsc;

    public SimpleStudentAdapter(Context context, int srsc, ArrayList<SimpleStudent> items) {
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
    public SimpleStudent getItem(int position) {
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
        TextView teacherName = (TextView) view.findViewById(R.id.name);
        TextView subject = (TextView) view.findViewById(R.id.category);

        imageView.setImageResource(R.drawable.student);
        SimpleStudent item = listViewItem.get(position);
        teacherName.setText(item.getName());
        subject.setText(item.getCategory());

        return view;
    }

}
