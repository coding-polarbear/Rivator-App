package com.rinc.bong.rivatorproject.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rinc.bong.rivatorproject.fragments.ContestCreateFragment;
import com.rinc.bong.rivatorproject.fragments.ContestJoinFragment;
import com.rinc.bong.rivatorproject.fragments.ProjectCreateFragment;
import com.rinc.bong.rivatorproject.fragments.ProjectJoinFragment;

import java.util.ArrayList;

/**
 * Created by bong on 2017-08-05.
 */

public class ContestPagerAdapter extends FragmentPagerAdapter {

    final int numOfTab = 2;
    final ArrayList<String> tabName = new ArrayList<>();

    public ContestPagerAdapter(FragmentManager fm) {
        super(fm);
        tabName.add("참가한 콘테스트");
        tabName.add("개최한 콘테스트");
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ContestJoinFragment.newInstance();
            case 1:
                return ContestCreateFragment.newInstance();
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
