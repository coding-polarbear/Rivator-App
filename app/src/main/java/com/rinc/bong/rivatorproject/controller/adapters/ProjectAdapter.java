package com.rinc.bong.rivatorproject.controller.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rinc.bong.rivatorproject.controller.fragments.DescriptionFragment;
import com.rinc.bong.rivatorproject.controller.fragments.TeamMemberFragment;

/**
 * Created by baehyeonbin on 2017. 8. 7..
 */

public class ProjectAdapter extends FragmentStatePagerAdapter {
    private String description;
    private int projectKey;
    public ProjectAdapter(FragmentManager fm, String description, int projectKey) {
        super(fm);
        this.description = description;
        this.projectKey = projectKey;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new DescriptionFragment(description);
            case 1:
                return new TeamMemberFragment(projectKey);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
