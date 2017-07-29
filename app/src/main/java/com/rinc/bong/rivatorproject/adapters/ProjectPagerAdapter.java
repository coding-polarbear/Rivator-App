package com.rinc.bong.rivatorproject.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rinc.bong.rivatorproject.R;
import com.rinc.bong.rivatorproject.fragments.HomeWorkNotSubmitFragment;
import com.rinc.bong.rivatorproject.fragments.HomeWorkSubmitFragment;
import com.rinc.bong.rivatorproject.fragments.ProjectCreateFragment;
import com.rinc.bong.rivatorproject.fragments.ProjectJoinFragment;

import java.util.ArrayList;

/**
 * Created by Bong on 2017-07-30.
 */

public class ProjectPagerAdapter extends FragmentPagerAdapter {

    final int numOfTab = 2;
    final ArrayList<String> tabName = new ArrayList<>();

    public ProjectPagerAdapter(FragmentManager fm) {
        super(fm);
        tabName.add("참가한 프로젝트");
        tabName.add("개최한 프로젝트");
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ProjectJoinFragment.newInstance();
            case 1:
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
            default:
                return null;
        }
    }
}