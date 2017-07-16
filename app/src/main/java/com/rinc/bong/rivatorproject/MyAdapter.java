package com.rinc.bong.rivatorproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by baehyeonbin on 2017. 7. 16..
 */

public class MyAdapter extends ArrayAdapter<MyItem> {
    private ArrayList<MyItem> listViewItem = new ArrayList<MyItem>();
    private Context context;
    private int srsc;

    public MyAdapter(Context context,int srsc, ArrayList<MyItem> items) {
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
    public MyItem getItem(int position) {
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

        ImageView imageView = (ImageView) view.findViewById(R.id.teacherImage);
        TextView teacherName = (TextView) view.findViewById(R.id.teacherName);
        TextView subject = (TextView) view.findViewById(R.id.subject);

        MyItem item = listViewItem.get(position);
        teacherName.setText(item.getTeacherName());
        subject.setText(item.getSubject());

        return view;
    }

}
