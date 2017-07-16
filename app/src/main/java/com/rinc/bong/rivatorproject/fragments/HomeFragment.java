package com.rinc.bong.rivatorproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.MyAdapter;
import com.rinc.bong.rivatorproject.MyItem;
import com.rinc.bong.rivatorproject.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private TextView moreText;
    private ListView listView;
    private MyAdapter adapter;
    public HomeFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container,false);
        moreText = (TextView) view.findViewById(R.id.moreText);
        moreText.setText(Html.fromHtml("<u>더보기<u>"));
        listView = (ListView) view.findViewById(R.id.teacherList);
        setListView();
        return view;
    }


    public void setListView() {
        ArrayList<MyItem> items = new ArrayList<MyItem> ();
        items.add(new MyItem("강사명","IT 분야"));
        items.add(new MyItem("강사명","IT 분야"));
        items.add(new MyItem("강사명","IT 분야"));
        items.add(new MyItem("강사명","IT 분야"));
        items.add(new MyItem("강사명","IT 분야"));
        Log.d("Test",items.get(0).getTeacherName());
        adapter = new MyAdapter(getActivity(), R.layout.teacher_listview, items);
        listView.setAdapter(adapter);
        ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged();
    }
}
