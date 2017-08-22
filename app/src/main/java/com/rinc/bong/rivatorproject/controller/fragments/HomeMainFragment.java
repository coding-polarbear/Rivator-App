package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.rinc.bong.rivatorproject.controller.adapters.ImageSlideAdapter;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.adapters.SimpleTeacherAdapter;
import com.rinc.bong.rivatorproject.controller.adapters.RecyclerItemAdapter;
import com.rinc.bong.rivatorproject.beans.CourseItem;
import com.rinc.bong.rivatorproject.beans.SimpleTeacher;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class HomeMainFragment extends Fragment {
    private TextView moreText1;
    private TextView moreText2;
    private TextView moreText3;
    private ListView listView;
    private SimpleTeacherAdapter adapter;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;

    private ViewPager homeImagePager = null;
    private ImageSlideAdapter homeImageAdapter = null;
    private CircleIndicator homePagerIndicator = null;

    private String[] testUri = {"http://ubuntu.doubtech.com/wp-content/uploads/2014/06/GDG-program-logo.png"
            , "http://ubuntu.doubtech.com/wp-content/uploads/2014/06/GDG-program-logo.png"
            , "http://ubuntu.doubtech.com/wp-content/uploads/2014/06/GDG-program-logo.png"};

    public HomeMainFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_main, container, false);

        moreText1 = (TextView) view.findViewById(R.id.moreText1);
        moreText2 = (TextView) view.findViewById(R.id.moreText2);
        moreText3 = (TextView) view.findViewById(R.id.moreText3);
        moreText1.setText(Html.fromHtml("<u>더보기<u>"));
        moreText2.setText(Html.fromHtml("<u>더보기<u>"));
        moreText3.setText(Html.fromHtml("<u>더보기<u>"));
        listView = (ListView) view.findViewById(R.id.teacherList);

        homeImagePager = (ViewPager) view.findViewById(R.id.home_image_slider);
        homePagerIndicator = (CircleIndicator) view.findViewById(R.id.home_is_indicator);

        //RecyclerView 초기화
        recyclerView1 = (RecyclerView) view.findViewById(R.id.recycler1);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.recycler2);
        setRecyclerView(recyclerView1);
        setRecyclerView(recyclerView2);

        setListView();
        initImageSlider();
        return view;
    }

    private void initImageSlider() {
        homeImageAdapter = new ImageSlideAdapter(getActivity(), testUri);
        homeImagePager.setAdapter(homeImageAdapter);
        homePagerIndicator.setViewPager(homeImagePager);
    }


    public void setListView() {
        ArrayList<SimpleTeacher> simpleTeachers = new ArrayList<SimpleTeacher>();
        SimpleTeacher test = new SimpleTeacher("강사명", "IT 분야");
        test.setSubject("Java Programming");
        test.setTeacherName("배현빈");
        simpleTeachers.add(test);
        //simpleTeachers.add(new SimpleTeacher("강사명", "IT 분야"));
        simpleTeachers.add(new SimpleTeacher("강사명", "IT 분야"));
        simpleTeachers.add(new SimpleTeacher("강사명", "IT 분야"));
        simpleTeachers.add(new SimpleTeacher("강사명", "IT 분야"));
        simpleTeachers.add(new SimpleTeacher("강사명", "IT 분야"));
        Log.d("Test", simpleTeachers.get(0).getTeacherName());
        adapter = new SimpleTeacherAdapter(getActivity(), R.layout.item_default_person_list, simpleTeachers);
        listView.setAdapter(adapter);
        ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
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

        RecyclerItemAdapter adapter = new RecyclerItemAdapter(getActivity(), myDataset);
        recyclerView.setAdapter(adapter);
    }
}