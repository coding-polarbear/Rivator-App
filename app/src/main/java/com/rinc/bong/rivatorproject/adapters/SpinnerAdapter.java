package com.rinc.bong.rivatorproject.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by baehyeonbin on 2017. 8. 17..
 */

public class SpinnerAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<String> list;
    public SpinnerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
        this.list = list;
    }

    @Override
    public boolean isEnabled(int position) {
        if(position == 0)
            return false;
        else
            return true;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);
        TextView textView = (TextView) view;
        if(position == 0)
            textView.setTextColor(Color.BLACK);
        else
            textView.setTextColor(Color.parseColor("#a0a0a0"));

        return view;
    }
}
