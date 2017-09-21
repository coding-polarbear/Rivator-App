package com.rinc.bong.rivatorproject.controller.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.rinc.bong.rivatorproject.controller.fragments.DescriptionFragment;
import com.rinc.bong.rivatorproject.controller.fragments.TeacherEvalFragment;

/**
 * Created by baehyeonbin on 2017. 9. 21..
 */

public class CourseAdapter extends FragmentStatePagerAdapter {
    private String description;
    public CourseAdapter(FragmentManager fm, String descriotion) {
        super(fm);
        this.description = descriotion;
    }
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new DescriptionFragment(description);
            case 1:
                return new TeacherEvalFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
