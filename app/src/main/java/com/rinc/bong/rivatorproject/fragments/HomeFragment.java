package com.rinc.bong.rivatorproject.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
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

import com.rinc.bong.rivatorproject.ImageSlideAdapter;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.adapters.MyAdapter;
import com.rinc.bong.rivatorproject.adapters.PageAdapter;
import com.rinc.bong.rivatorproject.adapters.RecyclerAdapter;
import com.rinc.bong.rivatorproject.beans.Item;
import com.rinc.bong.rivatorproject.beans.MyItem;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;


public class HomeFragment extends Fragment {
    private ArrayList<String> tabNames = new ArrayList<>();
    public HomeFragment() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        loadTabName();
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Tab Layout 설정
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab);
        tabNames.stream().forEach(name -> tabLayout.addTab(tabLayout.newTab().setText(name)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        //ViewPager 설정
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        final PageAdapter pageAdapter = new PageAdapter(getChildFragmentManager(),tabLayout.getTabCount(),tabNames);
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) viewPager.getLayoutParams();
        lp.topMargin += 100;
        viewPager.setAdapter(pageAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return view;
    }
    private void loadTabName() {
        tabNames.add("추천");
        tabNames.add("인기");
        tabNames.add("Basic");
        tabNames.add("웹");
        tabNames.add("어플리케이션");
        tabNames.add("게임");
        tabNames.add("안드로이드");
    }
}
