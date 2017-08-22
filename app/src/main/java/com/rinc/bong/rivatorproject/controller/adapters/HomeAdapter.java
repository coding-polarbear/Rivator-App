package com.rinc.bong.rivatorproject.controller.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rinc.bong.rivatorproject.controller.fragments.HomeMainFragment;
import com.rinc.bong.rivatorproject.controller.fragments.HomeSubjectFragment;

import java.util.ArrayList;

/**
 * Created by hynebinbae on 2017. 7. 24..
 */

public class HomeAdapter extends FragmentStatePagerAdapter{
    private ArrayList<String> tabNames;
    int numberOfTabs;

    public HomeAdapter(FragmentManager fm, int numberOfTabs, ArrayList<String> tabNames) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
        this.tabNames = tabNames;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new HomeMainFragment();
       } else {
            return new HomeSubjectFragment(tabNames.get(position));
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
