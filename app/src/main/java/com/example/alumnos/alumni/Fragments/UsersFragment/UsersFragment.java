package com.example.alumnos.alumni.Fragments.UsersFragment;


import android.os.Bundle;
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
public class UsersFragment extends Fragment {


    public UsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_users, container, false);
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.viewPager);
        setUpViewPager(viewPager);
        TabLayout tabs = view.findViewById(R.id.tabPanelUsers);
        tabs.setupWithViewPager(viewPager);

        return view;
    }


    private void setUpViewPager(ViewPager viewPager)
    {
        ViewPageAdapter adapter = new ViewPageAdapter(getFragmentManager());
        adapter.addFragment(new AllUsersFragment (),"Todos");
        adapter.addFragment(new GroupsFragment (),"Grupos");
        adapter.addFragment(new UsersFragment (),"Amigos");
        adapter.addFragment(new UsersRequestsFragment (),"Solicitudes");
        viewPager.setAdapter(adapter);
    }

}