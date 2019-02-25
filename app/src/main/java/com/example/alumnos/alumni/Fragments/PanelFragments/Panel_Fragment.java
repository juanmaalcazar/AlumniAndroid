package com.example.alumnos.alumni.Fragments.PanelFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alumnos.alumni.Adapters.ViewPageAdapter;
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
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_panel_, container, false);
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.viewPager);
        setUpViewPager(viewPager);

        TabLayout tabs = view.findViewById(R.id.tabPanel);
        tabs.setupWithViewPager(viewPager);

        return view;
    }


    private void setUpViewPager(ViewPager viewPager)
    {
        ViewPageAdapter adapter = new ViewPageAdapter(getFragmentManager());
        adapter.addFragment(new Calendar_Fragment(),"CALENDARIO");
        adapter.addFragment(new Asistance_Fragment(),"ASISTENCIA");
        adapter.addFragment(new Notes_Fragment(),"NOTAS");
        viewPager.setAdapter(adapter);

    }

}

