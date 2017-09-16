package com.rinc.bong.rivatorproject.controller.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.controller.adapters.HomeAdapter;
import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.controller.adapters.PageAdapter;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private View view;
    private TabLayout tabLayout;
    private ArrayList<String> tabNames = new ArrayList<>();
    private Fragment fragment;
    private int position;
    public HomeFragment(int position) {
        this.position = position;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        loadTabName();
        view = inflater.inflate(R.layout.fragment_home, container, false);
        setTabLayout();
        setViewPager(getAdapter());
        return view;
    }

    private FragmentStatePagerAdapter getAdapter() {
       if(position == 0) return new HomeAdapter(getChildFragmentManager(), tabLayout.getTabCount(), tabNames);
        else {
           return new PageAdapter(getChildFragmentManager(),tabLayout.getTabCount(), tabNames,position);
       }
    }
    //TabLayout 설정
    private void setTabLayout() {
        tabLayout = (TabLayout) view.findViewById(R.id.tab);
        //ArrayList에 있는 값들을 이터레이션 시켜서 탭 레이아웃에 새로운 탭 추가
        tabNames.stream().forEach(name -> tabLayout.addTab(tabLayout.newTab().setText(name)));
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER); //탭 가로 길이 가변 설정
    }
    //탭 이름 로딩
    private void loadTabName() {
        tabNames.add("추천");
//        tabNames.add("인기");
        tabNames.add("Basic");
        tabNames.add("웹");
        tabNames.add("어플리케이션");
        tabNames.add("게임");
    }

    //ViewPager설정
    private void setViewPager(FragmentStatePagerAdapter adapter) {
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        //final PageAdapter pageAdapter = new PageAdapter(getChildFragmentManager(),tabLayout.getTabCount(),tabNames);

        viewPager.setAdapter(adapter);
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
    }

}
