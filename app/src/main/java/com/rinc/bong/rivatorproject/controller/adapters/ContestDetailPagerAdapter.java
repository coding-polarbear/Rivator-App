package com.rinc.bong.rivatorproject.controller.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rinc.bong.rivatorproject.beans.Contest;
import com.rinc.bong.rivatorproject.controller.fragments.DescriptionFragment;

/**
 * Created by baehyeonbin on 2017. 9. 27..
 */

public class ContestDetailPagerAdapter extends FragmentPagerAdapter {
    private Context context;
    private Contest contest;
    public ContestDetailPagerAdapter(FragmentManager fm, Context context, Contest contest) {
        super(fm);
        this.context = context;
        this.contest = contest;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new DescriptionFragment(contest.getDescription());
            case 1:
                return new DescriptionFragment(contest.getCategory());
            case 2:
                return new DescriptionFragment(contest.getFiledEntry());
            case 3:
                return new DescriptionFragment(contest.getCriteria());
            case 4:
                return new DescriptionFragment(contest.getAward());
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
