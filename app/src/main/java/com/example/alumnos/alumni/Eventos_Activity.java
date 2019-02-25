package com.example.alumnos.alumni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alumnos.alumni.Api.ApiAlumni;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Eventos_Activity extends AppCompatActivity {

   // String URL = "http://10.0.2.2:8888/ProyectoAlumni-master/public/api/";
   String URL ="http://192.168.6.167/ProyectoAlumni/public/index.php/api/";
  // String URL = "http://192.168.6.167/ProyectoAlumni/public/index.php/api/";
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
        //createBtn = Butto


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( URL)
                .addConverterFactory( ScalarsConverterFactory.create())
                .addConverterFactory( GsonConverterFactory.create())
                .build();

        api = retrofit.create(ApiAlumni.class);
    }


    private View.OnClickListener send = new View.OnClickListener() {
        public void onClick(View v) {
            createEvent ( v );
        }
    };



    public void createEvent(View view) {

        Call<String> peticion = api.createEvent (title.getText ().toString (),description.getText ().toString (),1,1,"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZW1haWwiOiJtaWd1ZWxfaGVyZWRpYV9hcHBzMW1hMTcxOEBjZXYuY29tIiwidXNlcm5hbWUiOiJhZG1pbiIsInBhc3N3b3JkIjoiYWRtaW4iLCJpZF9yb2wiOjEsImlkX3ByaXZhY2l0eSI6MSwiZ3JvdXAiOm51bGx9.Lv2qTDtZdRsIeDs03zSXrEx8nJ4MkRUVFOlJNVRta88");

        peticion.enqueue(new Callback<String>() {
            @Override

            public void onResponse(Call<String> call, Response<String> response) {


                String resultado = response.body ();

                if (resultado == null)
                {
                    Log.d ( "null","esta entrando en nullo" );
                    try {
                        resultado = response.errorBody ().string ();
                        Toast.makeText(Eventos_Activity.this, resultado, Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
                }else {
                    Log.d ( "elseeeee:",resultado );
                    Toast.makeText(Eventos_Activity.this, "dame el tokeeeen", Toast.LENGTH_SHORT).show();
                    Toast.makeText(Eventos_Activity.this, resultado, Toast.LENGTH_SHORT).show();
                    //goToMenu ();
                }
            }


            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(Eventos_Activity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }

        });
    }





}




