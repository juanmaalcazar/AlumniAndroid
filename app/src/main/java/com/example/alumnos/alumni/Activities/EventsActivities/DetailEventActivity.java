package com.example.alumnos.alumni.Activities.EventsActivities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alumnos.alumni.Api.GlobalRequests;
import com.example.alumnos.alumni.Fragments.EventsFragments.Events_fragment;
import com.example.alumnos.alumni.Models.Event;
import com.example.alumnos.alumni.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;

public class DetailEventActivity extends AppCompatActivity {

    public static ArrayList<Event> eventsRecibed = new ArrayList<Event>();
    Button borrarBtn;
    Events_fragment fragmentEvent;

    public static Integer idEvent;


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
        //eventsRecibed.remove(0);

        borrarBtn = findViewById(R.id.deleteBtn);
        borrarBtn.setOnClickListener(deleteListener);



    }
    private View.OnClickListener deleteListener = new View.OnClickListener() {
        public void onClick(View v) {



            Log.d("***","El id del EVENTO es " + eventsRecibed.get(0).getId());
            idEvent = eventsRecibed.get(0).getId();

            AlertDialog.Builder adb=new AlertDialog.Builder(DetailEventActivity.this);
            adb.setTitle("Delete?");
            adb.setMessage("Are you sure you want to delete ");
            adb.setNegativeButton("Cancel", null);
            adb.setPositiveButton("Ok", new AlertDialog.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int which)
                {
                    goToMenu();
                    GlobalRequests globalRequests = new GlobalRequests();
                    globalRequests.deleteEvent();
                }
            });
            adb.show();

        }
    };

    private void goToMenu()
    {
        Intent intent = new Intent(this,MainMenuActivity.class);
        startActivity(intent);
    }


}
