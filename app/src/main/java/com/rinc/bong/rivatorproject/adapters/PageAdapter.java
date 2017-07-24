package com.rinc.bong.rivatorproject.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rinc.bong.rivatorproject.fragments.CurrentLectureFragment;
import com.rinc.bong.rivatorproject.fragments.HomeMainFragment;

/**
 * Created by hynebinbae on 2017. 7. 24..
 */

public class PageAdapter extends FragmentStatePagerAdapter{
    int numberOfTabs;

    public PageAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        if(position > 0) {
            HomeMainFragment homeMainFragment = new HomeMainFragment();
            return homeMainFragment;
        } else {
            CurrentLectureFragment currentLectureFragment = new CurrentLectureFragment();
            return currentLectureFragment;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
