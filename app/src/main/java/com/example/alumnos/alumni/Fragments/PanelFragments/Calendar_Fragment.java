package com.example.alumnos.alumni.Fragments.PanelFragments;



import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.alumnos.alumni.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;




/**
 * A simple {@link Fragment} subclass.
 */
public class Calendar_Fragment extends Fragment {

    TextView titleDate;
    CalendarView calendarView;
    String calendarDates;


    public Calendar_Fragment() {
        // Required empty public constructor
    }


    @TargetApi(28)
    @RequiresApi(api = 28)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendary, container, false);

         titleDate = view.findViewById(R.id.dateOfCalTxt);
         calendarView = view.findViewById(R.id.panelsCalendar);

         setDataCalendar();
         putMarksInCalendar();

         calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
             @Override
             public void onSelectedDayChange(CalendarView view, int year, int month,
                                             int dayOfMonth) {
                calendarDates = ""+dayOfMonth+"/"+ month +"/" + year;
                titleDate.setText(calendarDates);
             }
         });

        return  view;



    }


    public void setDataCalendar()
    {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String selectedDate = sdf.format(new Date(calendarView.getDate()));
        titleDate.setText(selectedDate);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public void putMarksInCalendar()
    {

        int redColorValue = Color.RED;
        int greenColorValue = Color.parseColor("#00ff00");
       // calendarView.setBackgroundColor(greenColorValue);




    }


}
