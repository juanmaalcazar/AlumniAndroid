package com.example.alumnos.alumni.Api;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.alumnos.alumni.Models.Event;
import com.example.alumnos.alumni.Models.JsonResponse;

import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.example.alumnos.alumni.Activities.DetailEventActivity.idEvent;
import static com.example.alumnos.alumni.Fragments.Events_fragment.eventsArrayList;


public class GlobalRequests {

   // String URL = "http://alumni.vanadis.es/alumni/public/index.php/api/";
    //String URL = "http://10.0.2.2:8888/ProyectoAlumni-master/public/api/";
    String URL = "http://192.168.6.167/ProyectoAlumni/public/index.php/api/";
    ApiAlumni api;
    Retrofit retrofit;
    private SharedPreferences prefs;

    public interface MyRequestListener {
        public void onGetEventsFinish();

    }

    private MyRequestListener listener;

    public GlobalRequests() {

        this.listener = null;

        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ApiAlumni.class);
    }

    public void setGlobalRequestsListener(MyRequestListener listener) {
        this.listener = listener;
    }





    public void getlistOfEvents()
    {
        Log.d("TOKEN", "OBTENIENDOOOOO TOOOOKEN");

        Call<JsonResponse> peticion = api.getEventsList ("type","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZW1haWwiOiJhZG1pbkBjZXYuY29tIiwidXNlcm5hbWUiOiJhZG1pbiIsInBhc3N3b3JkIjoiYWRtaW4iLCJpZF9yb2wiOjEsImlkX3ByaXZhY2l0eSI6MSwiZ3JvdXAiOm51bGx9.qhRcT-k8OEUCVFn8vJLapEGUekZGv13YWY90XqW6qCo");
        peticion.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                int code = response.body().getCode();
                JsonResponse json = response.body();
                Log.d ( "Respuesta del servidor", response.body ().getMessage () );

                switch (code) {
                    case 200:
                        String message = response.body ().getMessage ();
                        Log.d("RESOUESTA 200::", message);
                        eventsArrayList = (ArrayList<Event>) response.body().getData().getEvent();
                        Integer size =eventsArrayList.size();
                        Log.d ( "TAMAÑO DEL ARRAY", String.valueOf(size));
                        Log.d ( "REQUEST STATE", "FIN DE LA PETICION");

                        Collections.reverse(eventsArrayList);
                        listener.onGetEventsFinish ();

                        break;
                    case 400:
                       // Toast.makeText ( MainActivity.this, errorMessage, Toast.LENGTH_SHORT ).show ();
                        String errorMessage = response.body ().getMessage ();
                        Log.d("RESOUESTA 200::", errorMessage);
                        break;

                    default:
                        //Toast.makeText ( MainActivity.this, errrorMessage, Toast.LENGTH_SHORT ).show ();
                        String defaultmsg = response.body ().getMessage ();
                        Log.d("RESOUESTA 200::", defaultmsg);
                }

            }
            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

                Log.d ("Failture message", "ON FAILTUREEEEEEEEEEE");
                Log.d ("EL FALLO ES", String.valueOf(t));

            }

        });

    }

    public void deleteEvent()
    {

        Call<JsonResponse> peticion = api.delete (idEvent,"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZW1haWwiOiJhZG1pbkBjZXYuY29tIiwidXNlcm5hbWUiOiJhZG1pbiIsInBhc3N3b3JkIjoiYWRtaW4iLCJpZF9yb2wiOjEsImlkX3ByaXZhY2l0eSI6MSwiZ3JvdXAiOm51bGx9.qhRcT-k8OEUCVFn8vJLapEGUekZGv13YWY90XqW6qCo");
        peticion.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                int code = response.body().getCode();
                JsonResponse json = response.body();
                Log.d ( "Respuesta del servidor", response.body ().getMessage () );

                switch (code) {
                    case 200:
                        String message = response.body ().getMessage ();
                        Log.d("RESOUESTA 200::", message);
                        Log.d ( "REQUEST STATE", "FIN DE LA PETICION");

                        listener.onGetEventsFinish ();

                        break;
                    case 400:
                        // Toast.makeText ( MainActivity.this, errorMessage, Toast.LENGTH_SHORT ).show ();
                        String errorMessage = response.body ().getMessage ();
                        Log.d("RESOUESTA 200::", errorMessage);
                        break;

                    default:
                        //Toast.makeText ( MainActivity.this, errrorMessage, Toast.LENGTH_SHORT ).show ();
                        String defaultmsg = response.body ().getMessage ();
                        Log.d("RESOUESTA 200::", defaultmsg);
                }

            }
            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

                Log.d ("Failture message", "ON FAILTUREEEEEEEEEEE");
                Log.d ("EL FALLO ES", String.valueOf(t));

            }

        });

    }

    private void goToCreateEventActivity()
    {


        //Intent intent = new Intent(this, MainMenuActivity.class);
        //startActivity(intent);
    }
}