package com.rinc.bong.rivatorproject.factories;

import android.support.v4.app.Fragment;

import com.rinc.bong.rivatorproject.controller.fragments.CurrentLectureFragment;
import com.rinc.bong.rivatorproject.controller.fragments.TeacherFragment;

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

    public Fragment getFragment(int position,String subject) {
        if(position == 1) {
            return new TeacherFragment(subject);
        } else {
            return new CurrentLectureFragment();
        }
    }
}
