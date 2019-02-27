package com.example.alumnos.alumni.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alumnos.alumni.Api.ApiAlumni;
import com.example.alumnos.alumni.Models.JsonResponse;
import com.example.alumnos.alumni.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Eventos_Activity extends AppCompatActivity {

   // String URL = "http://10.0.2.2:8888/ProyectoAlumni-master/public/api/";
     String URL = "http://192.168.6.167/ProyectoAlumni/public/index.php/api/";
   ApiAlumni api;

   EditText title, description, date;
   Button sendDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_eventos_ );


        title = findViewById(R.id.eventTitleEditText);
        description = findViewById(R.id.eventDescriptionEditText);
        date = findViewById(R.id.eventDateEditTxt);
        sendDate = findViewById(R.id.sednDateBtn);
        sendDate.setOnClickListener(send);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( URL)
                .addConverterFactory( ScalarsConverterFactory.create())
                .addConverterFactory( GsonConverterFactory.create())
                .build();

        api = retrofit.create(ApiAlumni.class);
    }


    private View.OnClickListener send = new View.OnClickListener() {
        public void onClick(View v) {
            createEvent();
        }
    };



    public void createEvent() {

        Call<JsonResponse> peticion = api.createEvent (title.getText ().toString (),description.getText ().toString (),1,1,"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZW1haWwiOiJhZG1pbkBjZXYuY29tIiwidXNlcm5hbWUiOiJhZG1pbiIsInBhc3N3b3JkIjoiYWRtaW4iLCJpZF9yb2wiOjEsImlkX3ByaXZhY2l0eSI6MSwiZ3JvdXAiOm51bGx9.qhRcT-k8OEUCVFn8vJLapEGUekZGv13YWY90XqW6qCo");

        peticion.enqueue(new Callback<JsonResponse>() {
            @Override

            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                Log.d("**", "RESPUESTA " + response.body());
                JsonResponse json = response.body();
                int code = response.body().getCode();


                switch (code) {
                    case 200:
                        String message = response.body ().getMessage ();
                        Log.d("RESOUESTA 200::", message);
                        break;
                    case 400:
                        String errorMessage = response.body ().getMessage ();
                        Log.d("RESOUESTA ERROR::", errorMessage);
                        break;

                    default:
                        String defaultmsg = response.body ().getMessage ();
                        Log.d("RESOUESTA DEFAULT :", defaultmsg);
                }
            }



            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Toast.makeText(Eventos_Activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }

        });
    }





}




