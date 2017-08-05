package com.rinc.bong.rivatorproject.activitys;

import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.adapters.SimpleCourseAdapter;
import com.rinc.bong.rivatorproject.beans.SimpleCourse;

import java.util.ArrayList;

public class CalendarActivity extends AppCompatActivity {
    private ActionBar actionBar;
    private ListView listView;
    private ArrayList<SimpleCourse> itemList;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        itemList = new ArrayList<>();
        setCustomActionbar();
        setTabLayout();
        setListView();
    }

    private void setTabLayout() {
        tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.addTab(tabLayout.newTab().setText("과외목록"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER); //탭 가로 길이 가변 설정
    }

    public void setListView() {
        listView = (ListView) findViewById(R.id.listView);
        itemList.add(new SimpleCourse("웹프로그래밍","김철수","IT",123));
        itemList.add(new SimpleCourse("웹프로그래밍","김철수","IT",123));
        itemList.add(new SimpleCourse("웹프로그래밍","김철수","IT",123));
        itemList.add(new SimpleCourse("웹프로그래밍","김철수","IT",123));
        itemList.add(new SimpleCourse("웹프로그래밍","김철수","IT",123));
        SimpleCourseAdapter simpleCourseAdapter = new SimpleCourseAdapter(getApplicationContext(), R.layout.item_default_type_course, itemList);
        listView.setAdapter(simpleCourseAdapter);
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

        //레이아웃 높이 서렂ㅇ
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalItemsHeight + totalDividersHeight;
        listView.setLayoutParams(params);
        listView.requestLayout();
    }


    public void  setCustomActionbar() {
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        //ActionBar의 그림자를 제거합니다
        actionBar.setElevation(0);

        //layout을 가지고 와서 actionbar에 포팅을 시킵니다.
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.custom_action_bar, null);
        TextView textView = (TextView) customView.findViewById(R.id.title);
        textView.setText("캘린더");

        //ImageButton 리스너 설정
        Button imageButton = (Button) customView.findViewById(R.id.btnBack);
        imageButton.setOnClickListener(v -> {
            finish();
        });
        actionBar.setCustomView(customView);

        Toolbar parent = (Toolbar) customView.getParent();
        parent.setContentInsetsAbsolute(0,0);
    }
}
