package com.example.alumnos.alumni.Fragments;


import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.alumnos.alumni.Adapters.PagerAdapter;
import com.example.alumnos.alumni.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Panel_Fragment extends Fragment {


    public Panel_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_panel_, container, false);
    }

}
