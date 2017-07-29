package com.rinc.bong.rivatorproject.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rinc.bong.rivatorproject.fragments.HomeWorkNotSubmitFragment;
import com.rinc.bong.rivatorproject.fragments.HomeWorkSubmitFragment;
import com.rinc.bong.rivatorproject.fragments.NoticeNotReadFragment;
import com.rinc.bong.rivatorproject.fragments.NoticeReadFragment;

import java.util.ArrayList;

/**
 * Created by Bong on 2017-07-30.
 */

public class HomeWorkPagerAdapter extends FragmentPagerAdapter {

    final int numOfTab = 2;
    final ArrayList<String> tabName = new ArrayList<>();

    public HomeWorkPagerAdapter(FragmentManager fm) {
        super(fm);
        tabName.add("미제출 숙제");
        tabName.add("제출 숙제");
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return HomeWorkNotSubmitFragment.newInstance();
            case 1:
                return HomeWorkSubmitFragment.newInstance();
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
