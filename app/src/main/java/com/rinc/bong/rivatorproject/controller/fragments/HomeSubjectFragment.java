package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.adapters.RecyclerItemAdapter;
import com.rinc.bong.rivatorproject.beans.CourseItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class HomeSubjectFragment extends Fragment {
    private TextView moreText1;
    private TextView moreText2;
    private RecyclerView recycler1;
    private RecyclerView recycler2;
    private TextView subjectText;
    private String title;

    public HomeSubjectFragment() {

    }
    public HomeSubjectFragment(String title) {
        // Required empty public constructor
        this.title = title;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_subject, container, false);

        //제목 텍스트 설정
        subjectText = (TextView) view.findViewById(R.id.subjectText);
        subjectText.setText(title);
        //더보기 활성화
        moreText1 = (TextView)view.findViewById(R.id.moreText1);
        moreText2 = (TextView)view.findViewById(R.id.moreText2);
        moreText1.setText(Html.fromHtml("<u>더보기<u>"));
        moreText2.setText(Html.fromHtml("<u>더보기<u>"));

        //RecyclerView 설정
        recycler1 = (RecyclerView) view.findViewById(R.id.recycler1);
        recycler2 = (RecyclerView) view.findViewById(R.id.recycler2);
        setRecyclerView(recycler1);
        setRecyclerView(recycler2);

        return view;
    }
    public void setRecyclerView(RecyclerView recyclerView) {
        ArrayList<CourseItem> myDataset = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        myDataset.add(new CourseItem("디자이너들은\n" + "이 곳에 모이…"));
        myDataset.add(new CourseItem("디자이너들은\n" + "이 곳에 모이…"));
        myDataset.add(new CourseItem("디자이너들은\n" + "이 곳에 모이…"));
        myDataset.add(new CourseItem("디자이너들은\n" + "이 곳에 모이…"));

        RecyclerItemAdapter<RecyclerView.ViewHolder> adapter = new RecyclerItemAdapter<RecyclerView.ViewHolder>(getActivity(), myDataset);
        recyclerView.setAdapter(adapter);
    }
}
