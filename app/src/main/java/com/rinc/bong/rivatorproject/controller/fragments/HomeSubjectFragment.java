package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.SimpleCourse;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.adapters.RecyclerItemAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.CourseListGet;
import com.rinc.bong.rivatorproject.services.CourseService;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private Call<CourseListGet> call;
    private User user;
    private View view;
    private CourseService courseService;
    List<SimpleCourse> myDataset = new ArrayList<>();


    public HomeSubjectFragment() {

    }
    public HomeSubjectFragment(String title) {
        // Required empty public constructor
        this.title = title;
        user = User.last(User.class);
        courseService = RetrofitUtil.retrofit.create(CourseService.class);
        call = courseService.getCourseList(title,true, "score", 0, 5);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home_subject, container, false);

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
        loadData();

        return view;
    }

    private void loadData() {
        call.enqueue(new Callback<CourseListGet>() {
            @Override
            public void onResponse(Call<CourseListGet> call, Response<CourseListGet> response) {
                Result result = response.body().getResult();
                if(result.getSuccess().equals("200")) {
                    myDataset = response.body().getSimpleCourseList();
                    setRecyclerView(recycler1);
                    setRecyclerView(recycler2);
                } else {
                    SnackBarUtill.makeSnackBar(view, result.getMessage(), Snackbar.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<CourseListGet> call, Throwable t) {
                SnackBarUtill.makeSnackBar(view, "알 수 없는 오류가 발생하여 데이터를 로딩할 수 없습니다",Snackbar.LENGTH_LONG);
            }
        });
    }
    public void setRecyclerView(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerItemAdapter<RecyclerView.ViewHolder> adapter = new RecyclerItemAdapter<RecyclerView.ViewHolder>(getActivity(), myDataset);
        recyclerView.setAdapter(adapter);

//        recyclerView.addOnItemTouchListener(new RecyclerClickListenerUtil(getContext(),recyclerView, new RecyclerClickListenerUtil.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(View view, int position) {
//                Intent i = new Intent(getActivity(), ProjectDetailActivity.class);
//                startActivity(i);
//            }
//
//            @Override
//            public void onLongItemClick(View view, int position) {
//
//            }
//        }));
    }
}
