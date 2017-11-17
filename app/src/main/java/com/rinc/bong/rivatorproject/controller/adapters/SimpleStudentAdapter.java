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

import com.bumptech.glide.Glide;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.ProjectManager;
import com.rinc.bong.rivatorproject.beans.SimpleStudent;
import com.rinc.bong.rivatorproject.beans.SimpleTeacher;
import com.rinc.bong.rivatorproject.beans.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baehyeonbin on 2017. 8. 19..
 */

public class SimpleStudentAdapter extends ArrayAdapter {
    private List<ProjectManager> listViewItem = new ArrayList<ProjectManager>();
    private Context context;
    private int srsc;

    public SimpleStudentAdapter(Context context, int srsc, List<ProjectManager> items) {
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
    public ProjectManager getItem(int position) {
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

        imageView.setImageResource(R.drawable.student);
        ProjectManager item = listViewItem.get(position);
        teacherName.setText(item.getUser().getUserName());
        subject.setText(item.getTeamPart());
        Glide.with(context).load("http://n0rr.kro.kr:7001/users/" + item.getUser().getUserId() + "/profile-image.jpg").into(imageView);

        return view;
    }

}
