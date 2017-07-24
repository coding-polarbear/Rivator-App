package com.rinc.bong.rivatorproject.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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

        } else {

        }
        return null;
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
