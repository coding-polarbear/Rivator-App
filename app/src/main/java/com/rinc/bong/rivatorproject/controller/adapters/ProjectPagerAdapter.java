package com.rinc.bong.rivatorproject.controller.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rinc.bong.rivatorproject.controller.fragments.ProjectCreateFragment;
import com.rinc.bong.rivatorproject.controller.fragments.ProjectJoinFragment;
import com.rinc.bong.rivatorproject.controller.fragments.ProjectListFragment;

import java.util.ArrayList;

/**
 * Created by Bong on 2017-07-30.
 */

public class ProjectPagerAdapter extends FragmentPagerAdapter {

    final int numOfTab = 3;
    final ArrayList<String> tabName = new ArrayList<>();

    public ProjectPagerAdapter(FragmentManager fm) {
        super(fm);
        tabName.add("모든 프로젝트");
        tabName.add("참가한 프로젝트");
        tabName.add("개최한 프로젝트");
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ProjectListFragment.newInstance();
            case 1:
                return ProjectJoinFragment.newInstance();
            case 2:
                return ProjectCreateFragment.newInstance();
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