package com.pioneer.bottomtab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by pioneerchang on 2017/8/26.
 */

public class TabAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    public TabAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.mFragments = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

}
