package com.rinc.bong.rivatorproject.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rinc.bong.rivatorproject.fragments.CurrentLectureFragment;
import com.rinc.bong.rivatorproject.fragments.HomeMainFragment;
import com.rinc.bong.rivatorproject.fragments.HomeSubjectFragment;

import java.util.ArrayList;

/**
 * Created by hynebinbae on 2017. 7. 24..
 */

public class PageAdapter extends FragmentStatePagerAdapter{
    private ArrayList<String> tabNames;
    int numberOfTabs;

    public PageAdapter(FragmentManager fm, int numberOfTabs, ArrayList<String> tabNames) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
        this.tabNames = tabNames;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            HomeMainFragment homeMainFragment = new HomeMainFragment();
            return homeMainFragment;
       } else {
            HomeSubjectFragment homeSubjectFragment = new HomeSubjectFragment(tabNames.get(position));
            return homeSubjectFragment;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
