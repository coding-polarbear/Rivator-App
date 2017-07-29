package com.rinc.bong.rivatorproject.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rinc.bong.rivatorproject.factories.FragmentFactory;

import java.util.ArrayList;

/**
 * Created by baehyeonbin on 2017. 7. 30..
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    private FragmentManager manager;
    private ArrayList<String> tabNames;
    private int numberOfTabs;
    private Fragment fragment;
    private int number;
    public PageAdapter(FragmentManager fm, int numberOfTabs, ArrayList<String> tabNames, int number) {
        super(fm);
        this.manager = fm;
        this.tabNames = tabNames;
        this.numberOfTabs = numberOfTabs;
        this.number = number;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.getInstance().getFragment(number,tabNames.get(position));
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
