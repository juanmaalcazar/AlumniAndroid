package com.example.alumnos.alumni.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



import com.example.alumnos.alumni.Fragments.Calendar_fragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;


    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super ( fm );
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return new Calendar_fragment ();
            case 1:
                return null;
            case 2:
                return null;
                default:
                    return null;

        }

    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
