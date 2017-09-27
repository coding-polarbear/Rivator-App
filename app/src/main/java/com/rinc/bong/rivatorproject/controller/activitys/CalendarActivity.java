package com.rinc.bong.rivatorproject.controller.activitys;

import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.beans.Course;
import com.rinc.bong.rivatorproject.beans.Result;
import com.rinc.bong.rivatorproject.beans.SimpleTeacher;
import com.rinc.bong.rivatorproject.beans.User;
import com.rinc.bong.rivatorproject.controller.adapters.CalendarAdapter;
import com.rinc.bong.rivatorproject.controller.adapters.SimpleCourseAdapter;
import com.rinc.bong.rivatorproject.beans.SimpleCourse;
import com.rinc.bong.rivatorproject.controller.adapters.SimpleTeacherAdapter;
import com.rinc.bong.rivatorproject.retrofitBean.CourseListGet;
import com.rinc.bong.rivatorproject.services.CourseService;
import com.rinc.bong.rivatorproject.utils.ActionbarCustomUtil;
import com.rinc.bong.rivatorproject.utils.RetrofitUtil;
import com.rinc.bong.rivatorproject.utils.SnackBarUtill;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalendarActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Course> itemList;
    private TabLayout tabLayout;
    private ScrollView scrollView;
    private CourseService courseService;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        //스크롤뷰 자동 스크롤 설정
        scrollView = findViewById(R.id.scrollView);
        scrollView.post(() -> {
            scrollView.fullScroll(ScrollView.FOCUS_UP);
        });

        itemList = new ArrayList<Course>();
        setCustomActionbar();
        setTabLayout();
        setListView();
    }

    private void init() {
        courseService = RetrofitUtil.retrofit.create(CourseService.class);
        user = User.last(User.class);
    }

    private void setTabLayout() {
        tabLayout = findViewById(R.id.tab);
        tabLayout.addTab(tabLayout.newTab().setText("과외목록"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER); //탭 가로 길이 가변 설정
    }

    public void setListView() {
        listView = findViewById(R.id.listView);
        CalendarAdapter calendarAdapter = new CalendarAdapter(getApplicationContext(), R.layout.item_default_type_course, itemList);
        listView.setAdapter(calendarAdapter);
        setListViewHeightBasedOnItems(listView);
    }

    //ListView 동적 높이 지정
    public void setListViewHeightBasedOnItems(ListView listView) {

        // Get list adpter of listview;
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)  return;

        int numberOfItems = listAdapter.getCount();

        // 아이템의 높이 구하기
        int totalItemsHeight = 0;
        for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
            View item = listAdapter.getView(itemPos, null, listView);
            item.measure(0, 0);
            totalItemsHeight += item.getMeasuredHeight();
        }

        // item divider에 따른 높이 설정
        int totalDividersHeight = listView.getDividerHeight() *  (numberOfItems - 1);

        //레이아웃 높이 설정
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalItemsHeight + totalDividersHeight;
        listView.setLayoutParams(params);
        listView.requestLayout();
    }


    public void  setCustomActionbar() {

        ActionbarCustomUtil mActionbar = new ActionbarCustomUtil(getApplicationContext(), getSupportActionBar(), R.layout.custom_action_bar, view -> {

            TextView textView = view.findViewById(R.id.title);
            textView.setText("캘린더");

            //ImageButton 리스너 설정
            ImageButton imageButton = view.findViewById(R.id.btnBack);
            imageButton.setOnClickListener(v -> finish());

        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mActionbar.setActionBarElevation(15);
        }

    }
}
