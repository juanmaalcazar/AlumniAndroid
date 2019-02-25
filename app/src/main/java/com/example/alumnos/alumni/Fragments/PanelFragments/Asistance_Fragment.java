package com.example.alumnos.alumni.Fragments.PanelFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alumnos.alumni.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Asistance_Fragment extends Fragment {


    public Asistance_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_asistance, container, false);
        return  view;
    }

}
