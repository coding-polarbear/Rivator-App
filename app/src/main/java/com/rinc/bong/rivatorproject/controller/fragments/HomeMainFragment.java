package com.rinc.bong.rivatorproject.controller.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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

import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.SimpleCourse;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.activitys.ProjectDetailActivity;
import com.rinc.bong.rivatorproject.controller.adapters.ImageSlideAdapter;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.adapters.SimpleTeacherAdapter;
import com.rinc.bong.rivatorproject.controller.adapters.RecyclerItemAdapter;
import com.rinc.bong.rivatorproject.beans.SimpleTeacher;
import com.rinc.bong.rivatorproject.retrofitBean.CourseListGet;
import com.rinc.bong.rivatorproject.retrofitBean.TeacherListGet;
import com.rinc.bong.rivatorproject.services.TeacherService;
import com.rinc.bong.rivatorproject.utils.ListViewUtill;
import com.rinc.bong.rivatorproject.utils.RecyclerClickListenerUtil;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.services.CourseService;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Path;

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
    private RecyclerView recyclerView;
    private User user;
    private View view;
    private List<User> teacherList = new ArrayList<>();
    private List<SimpleCourse> myDataset = new ArrayList<>();

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
        view = inflater.inflate(R.layout.fragment_home_main, container, false);
        init();
        loadCourseData();
        loadTeacherData();
        initImageSlider();
        return view;
    }

    private void init(){
        moreText1 = (TextView) view.findViewById(R.id.moreText1);
        moreText2 = (TextView) view.findViewById(R.id.moreText2);
        moreText1.setText(Html.fromHtml("<u>더보기<u>"));
        moreText2.setText(Html.fromHtml("<u>더보기<u>"));
        listView = (ListView) view.findViewById(R.id.teacherList);

        homeImagePager = (ViewPager) view.findViewById(R.id.home_image_slider);
        homePagerIndicator = (CircleIndicator) view.findViewById(R.id.home_is_indicator);

        //RecyclerView 초기화
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        user = User.last(User.class);
    }

    private void initImageSlider() {
        homeImageAdapter = new ImageSlideAdapter(getActivity(), testUri);
        homeImagePager.setAdapter(homeImageAdapter);
        homePagerIndicator.setViewPager(homeImagePager);
    }


    public void setListView() {
        adapter = new SimpleTeacherAdapter(getContext(), R.layout.item_default_person_list, teacherList);
        listView.setAdapter(adapter);
        ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
        ListViewUtill.setListViewHeightBasedOnChildren(listView);
    }

    private void loadCourseData() {
        CourseService courseService = RetrofitUtil.retrofit.create(CourseService.class);
        Call<CourseListGet> call = courseService.getCourseList(user.getSubject(), true, "score", 0, 5);
        call.enqueue(new Callback<CourseListGet>() {
            @Override
            public void onResponse(Call<CourseListGet> call, Response<CourseListGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    myDataset = response.body().getSimpleCourseList();
                    setRecyclerView(recyclerView);
                } else {
                    SnackBarUtill.makeSnackBar(view,result.getMessage(), Snackbar.LENGTH_LONG);
                }

            }

            @Override
            public void onFailure(Call<CourseListGet> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생하여 데이터를 로딩할 수 없습니다.",Snackbar.LENGTH_LONG);
            }
        });
    }

    private void loadTeacherData() {
        TeacherService teacherService = RetrofitUtil.retrofit.create(TeacherService.class);
        Call<TeacherListGet> call = teacherService.loadTeacherWithSubject(0,5,user.getSubject(),true, "teacher");
        call.enqueue(new Callback<TeacherListGet>() {
            @Override
            public void onResponse(Call<TeacherListGet> call, Response<TeacherListGet> response) {
                if(response.body().getResult().getSuccess().equals("200")) {
                    teacherList = response.body().getUsers();
                    setListView();
                } else {
                    SnackBarUtill.makeSnackBar(view,response.body().getResult().getMessage(), Snackbar.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<TeacherListGet> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생하였습니다!", Snackbar.LENGTH_LONG);
            }
        });
    }
    @Override
    public void onResume() {
        super.onResume();
        loadCourseData();
        loadTeacherData();
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerItemAdapter adapter = new RecyclerItemAdapter(getActivity(), myDataset);
        recyclerView.setAdapter(adapter);
    }
}
