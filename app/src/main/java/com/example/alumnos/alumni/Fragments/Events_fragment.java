package com.example.alumnos.alumni.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alumnos.alumni.Activities.DetailEventActivity;
import com.example.alumnos.alumni.Adapters.MyAdapter;
import com.example.alumnos.alumni.Api.GlobalRequests;
import com.example.alumnos.alumni.Activities.Eventos_Activity;
import com.example.alumnos.alumni.Models.Event;
import com.example.alumnos.alumni.R;

import java.util.ArrayList;

import static com.example.alumnos.alumni.Activities.DetailEventActivity.eventsRecibed;

/**
 * A simple {@link Fragment} subclass.
 */
public class Events_fragment extends Fragment {

    MyAdapter myAdapter;

    ImageView imageEvent;

    public static ArrayList<Event> eventsArrayList = new ArrayList<Event>();
    public static ListView listView;
    private FloatingActionButton addEventBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_events_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Toast.makeText(getActivity().getApplicationContext(), "EVENTOS LANZADOS!!!", Toast.LENGTH_SHORT).show();

        GlobalRequests globalRequests = new GlobalRequests();
        globalRequests.setGlobalRequestsListener ( new GlobalRequests.MyRequestListener () {
            @Override
            public void onGetEventsFinish() {
                myAdapter = new MyAdapter(getActivity().getApplicationContext(), R.layout.list_item, eventsArrayList);
                listView.setAdapter(myAdapter);
            }
        } );

        globalRequests.getlistOfEvents();
        addEventBtn = getView().findViewById(R.id.floatBtn);
        addEventBtn.setOnClickListener(myEventListener);
        listView = (ListView) getView().findViewById(R.id.eventsListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity().getApplicationContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                Integer idEvent = Integer.valueOf(eventsArrayList.get(position).getId());
                String currentName = String.valueOf(eventsArrayList.get(position));
                String description = String.valueOf(eventsArrayList.get(position).getDescription());
                String date =  String.valueOf(eventsArrayList.get(position).getDate ());
                Event eventSended  = eventsArrayList.get (position);
                eventsRecibed.add(0, eventSended);
                Toast.makeText(getActivity().getApplicationContext(), "evento enviado!", Toast.LENGTH_SHORT).show();
                goToDetailEvent();

            }
        });

    }


    private View.OnClickListener myEventListener = new View.OnClickListener() {
        public void onClick(View v) {
            //Toast.makeText(getActivity().getApplicationContext(), "CLICK!", Toast.LENGTH_SHORT).show();
            goToCreateEventActivity();
        }
    };


    private void goToCreateEventActivity()
    {
        Intent intent = new Intent(getActivity().getApplicationContext(),Eventos_Activity.class);
        startActivity(intent);
    }

    private void goToDetailEvent()
    {
        Intent intent = new Intent(getActivity().getApplicationContext(),DetailEventActivity.class);
        startActivity(intent);
    }


}

