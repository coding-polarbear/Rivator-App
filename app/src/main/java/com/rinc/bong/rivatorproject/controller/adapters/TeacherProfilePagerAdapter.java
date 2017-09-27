package com.rinc.bong.rivatorproject.controller.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rinc.bong.rivatorproject.controller.fragments.LectureSearchFragment;
import com.rinc.bong.rivatorproject.controller.fragments.TeacherProfileFragment;
import com.rinc.bong.rivatorproject.controller.fragments.TeacherSearchFragment;

import java.util.ArrayList;

/**
 * Created by Bong on 2017-07-30.
 */

public class TeacherProfilePagerAdapter extends FragmentPagerAdapter {

    final int numOfTab = 3;
    final ArrayList<String> tabName = new ArrayList<>();

    public TeacherProfilePagerAdapter(FragmentManager fm) {
        super(fm);
        tabName.add("과외 목록");
        tabName.add("콘테스트 목록");
        tabName.add("프로젝트 목록");
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return TeacherProfileFragment.newInstance();
            case 1:
                return TeacherProfileFragment.newInstance();
            case 2:
                return TeacherProfileFragment.newInstance();
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
            case 2:
                return tabName.get(position);
            default:
                return null;
        }
    }
}
