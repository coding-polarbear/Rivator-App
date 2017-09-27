package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rinc.bong.rivatorproject.beans.SimpleTeacher;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baehyeonbin on 2017. 7. 16..
 */

public class SimpleTeacherAdapter extends ArrayAdapter<User> {
    private List<User> listViewItem = new ArrayList<User>();
    private Context context;
    private int srsc;

    public SimpleTeacherAdapter(Context context, int srsc, List<User> items) {
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
    public User getItem(int position) {
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

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView teacherName = view.findViewById(R.id.name);
        TextView subject = view.findViewById(R.id.category);

        User item = listViewItem.get(position);
        teacherName.setText(item.getUserName());
        Glide.with(context).load("http://n0rr.iptime.org:7001/users/"+ item.getUserId() +"/profile-image.jpg").centerCrop().into(imageView);
        subject.setText(item.getSubject());

        return view;
    }

}
