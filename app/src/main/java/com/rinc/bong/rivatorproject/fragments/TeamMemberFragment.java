package com.rinc.bong.rivatorproject.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.adapters.SimpleStudentAdapter;
import com.rinc.bong.rivatorproject.beans.SimpleStudent;

import java.util.ArrayList;


public class TeamMemberFragment extends Fragment {
    private ListView listView = null;
    private View view = null;
    private SimpleStudentAdapter adapter;
    public TeamMemberFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_team_member, container, false);
        init();
        setListView();
        return view;
    }

        private void init() {
            listView = (ListView) view.findViewById(R.id.listView);
        }

    private void setListView() {
        //더미데이터 넣어줌
        ArrayList<SimpleStudent> dummy = new ArrayList<>();
        dummy.add(new SimpleStudent("학생명","IT분야"));
        dummy.add(new SimpleStudent("학생명","IT분야"));
        dummy.add(new SimpleStudent("학생명","IT분야"));
        dummy.add(new SimpleStudent("학생명","IT분야"));
        dummy.add(new SimpleStudent("학생명","IT분야"));
        dummy.add(new SimpleStudent("학생명","IT분야"));
        dummy.add(new SimpleStudent("학생명","IT분야"));
        dummy.add(new SimpleStudent("학생명","IT분야"));

        //리스트뷰의 아이템을 설정할 array adapter 생성
        adapter = new SimpleStudentAdapter(getActivity(),R.layout.item_default_person_list,dummy);
        listView.setAdapter(adapter);

        //리스트뷰에 데이터가 추가된 것을 알림
        ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
    }
}
