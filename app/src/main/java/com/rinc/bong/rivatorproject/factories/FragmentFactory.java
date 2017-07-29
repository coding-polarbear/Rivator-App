package com.rinc.bong.rivatorproject.factories;

import android.support.v4.app.Fragment;

import com.rinc.bong.rivatorproject.fragments.CurrentLectureFragment;
import com.rinc.bong.rivatorproject.fragments.TeacherFragment;

/**
 * Created by baehyeonbin on 2017. 7. 30..
 */

public class FragmentFactory {
    private static final FragmentFactory ourInstance = new FragmentFactory();

    public static FragmentFactory getInstance() {
        return ourInstance;
    }

    private FragmentFactory() {
    }

    public Fragment getFragment(int position) {
        if(position == 1) {
            return new TeacherFragment();
        } else {
            return new CurrentLectureFragment();
        }
    }
}
