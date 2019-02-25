package com.example.alumnos.alumni.Activities;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alumnos.alumni.Models.Event;
import com.example.alumnos.alumni.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailEventActivity extends AppCompatActivity {

    public static ArrayList<Event> eventsRecibed = new ArrayList<Event>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_event);

        Log.d ( "PANTALLA DETALLE", "CARGANDO DATOS RECIBIDOS");
        String titulo = eventsRecibed.get (0).getTitle();
        Log.d ( "DATOS ", "LOS DATOS SON" + titulo);


        ImageView eventImage = (ImageView) findViewById(R.id.eventImage);
        TextView title = (TextView) findViewById(R.id.detailTile);
        TextView date = (TextView) findViewById(R.id.detailEventDate);
        TextView description = (TextView) findViewById(R.id.detailDescription);

        title.setText(titulo);
        title.setTextColor(Color.parseColor("#FFFFFF"));
        date.setText(eventsRecibed.get (0).getDate ());
        date.setTextColor(Color.parseColor("#FFFFFF"));
        description.setText(eventsRecibed.get (0).getDescription ());
        Picasso.get().load(eventsRecibed.get (0).getImage ()).into((eventImage));
        eventsRecibed.remove(0);


    }




}
