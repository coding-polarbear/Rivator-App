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

import com.rinc.bong.rivatorproject.adapters.MyAdapter;
import com.rinc.bong.rivatorproject.beans.MyItem;
import com.rinc.bong.rivatorproject.R;

import java.util.ArrayList;


public class TeacherFragment extends Fragment {
    private TextView moreText;
    private ListView listView;
    private MyAdapter myAdapter;
    private TextView subjectText;
    private String subject;
    public TeacherFragment() {
        // Required empty public constructor
    }

    public TeacherFragment(String subject) {
        this.subject = subject;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_teacher, container,false);
        moreText = (TextView) view.findViewById(R.id.moreText);
        moreText.setText(Html.fromHtml("<u>더보기<u>"));
        listView = (ListView) view.findViewById(R.id.teacherList);
        subjectText = (TextView) view.findViewById(R.id.subjectText);
        subjectText.setText(subject);
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
        myAdapter = new MyAdapter(getActivity(), R.layout.teacher_listview, items);
        listView.setAdapter(myAdapter);
        ((BaseAdapter)listView.getAdapter()).notifyDataSetChanged();
    }

}
