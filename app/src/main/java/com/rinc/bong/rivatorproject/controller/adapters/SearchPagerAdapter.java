package com.rinc.bong.rivatorproject.controller.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rinc.bong.rivatorproject.controller.fragments.LectureSearchFragment;
import com.rinc.bong.rivatorproject.controller.fragments.TeacherSearchFragment;

import java.util.ArrayList;

/**
 * Created by Bong on 2017-07-30.
 */

public class SearchPagerAdapter extends FragmentPagerAdapter {

    final int numOfTab = 2;
    final ArrayList<String> tabName = new ArrayList<>();

    public SearchPagerAdapter(FragmentManager fm) {
        super(fm);
        tabName.add("강사 검색");
        tabName.add("강좌 검색");
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return TeacherSearchFragment.newInstance();
            case 1:
                return LectureSearchFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTab;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return tabName.get(position);
            case 1:
                return tabName.get(position);
            default:
                return null;
        }
    }
}
