package com.example.fragmentshome;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.fragmentshome.tab_fragments.Fragment1_TabFragment1;
import com.example.fragmentshome.tab_fragments.Fragment1_TabFragment2;
import com.example.fragmentshome.tab_fragments.Fragment1_TabFragment3;

/**
 * Created by Hrant on 18.05.2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int numberOfTabs;

    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Fragment1_TabFragment1();
            case 1: return new Fragment1_TabFragment2();
            case 2: return new Fragment1_TabFragment3();
        }
        return null;
    }
    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
