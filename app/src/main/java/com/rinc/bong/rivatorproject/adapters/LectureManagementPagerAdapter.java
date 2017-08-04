package com.rinc.bong.rivatorproject.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rinc.bong.rivatorproject.fragments.LectureApplyFragment;
import com.rinc.bong.rivatorproject.fragments.LectureEndFragment;
import com.rinc.bong.rivatorproject.fragments.LectureDuringFragment;

import java.util.ArrayList;

/**
 * Created by bong on 2017-08-05.
 */

public class LectureManagementPagerAdapter extends FragmentPagerAdapter {

    final int numOfTab = 3;
    final ArrayList<String> tabName = new ArrayList<>();

    public LectureManagementPagerAdapter(FragmentManager fm) {
        super(fm);
        tabName.add("수강중인 강좌");
        tabName.add("신청한 강좌");
        tabName.add("수강종료 강좌");
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return LectureDuringFragment.newInstance();
            case 1:
                return LectureApplyFragment.newInstance();
            case 2:
                return LectureEndFragment.newInstance();
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
