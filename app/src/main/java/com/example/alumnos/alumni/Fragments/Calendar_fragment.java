package com.example.alumnos.alumni.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alumnos.alumni.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Calendar_fragment extends Fragment {


    public Calendar_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view = inflater.inflate ( R.layout.fragment_calendar_fragment, container, false );
     return view;
    }

}
