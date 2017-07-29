package com.rinc.bong.rivatorproject.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rinc.bong.rivatorproject.fragments.NoticeNotReadFragment;
import com.rinc.bong.rivatorproject.fragments.NoticeReadFragment;

import java.util.ArrayList;

/**
 * Created by Bong on 2017-07-30.
 */

public class NoticePagerAdapter extends FragmentPagerAdapter {

    final int numOfTab = 2;
    final ArrayList<String> tabName = new ArrayList<>();

    public NoticePagerAdapter(FragmentManager fm) {
        super(fm);
        tabName.add("읽지 않은 알림");
        tabName.add("읽은 알림");
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return NoticeNotReadFragment.newInstance();
            case 1:
                return NoticeReadFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
