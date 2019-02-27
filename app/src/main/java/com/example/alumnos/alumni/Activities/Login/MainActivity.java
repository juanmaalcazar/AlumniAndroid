package com.example.alumnos.alumni.Activities.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alumnos.alumni.Activities.EventsActivities.MainMenuActivity;
import com.example.alumnos.alumni.Api.ApiAlumni;
import com.example.alumnos.alumni.Models.JsonResponse;
import com.example.alumnos.alumni.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.example.alumnos.alumni.Api.GlobalRequests.urlVirtual;

public class MainActivity extends AppCompatActivity {

    ApiAlumni api;

    //String URL ="http://alumni.vanadis.es/alumni/public/index.php/api/";
    //String URL = "http://10.0.2.2:8888/ProyectoAlumni-master/public/api/";
    EditText email, password;
    Button sendBtn, registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );


        email = findViewById(R.id.emailTxt);
        password = findViewById(R.id.passwordText);
        sendBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(mCorkyListener);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlVirtual)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(ApiAlumni.class);

        Log.d ( "PREFERENCIAS", "CARGANDO PREFERENCIAAAAAAAAAAAAAAAAAAAAAAAAAS" );
        SharedPreferences prefs = getSharedPreferences("userPrefs", MODE_PRIVATE);
        if(prefs.contains("email") && prefs.contains("pass")&& prefs.contains("token"))
        {
            Log.d ( "ESTADO PREFS:", "EXISITEN PREFERECNIAS" );
            goToMenu();


        }
        else{
            Log.d("ESTADO PREFS:", "NO EXISITEN PREFERECNIAS");
        }
    }



    private View.OnClickListener mCorkyListener = new View.OnClickListener() {
        public void onClick(View v) {
            openRegister();
        }
    };

    public void openRegister()
    {
        Intent intent = new Intent(this,Register_Activity.class);
        startActivity(intent);

    }



    public void login(View view) {

        Call<JsonResponse> peticion = api.login (email.getText().toString(), password.getText().toString());
        peticion.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                int code = response.body ().getCode ();
                JsonResponse json = response.body();

                Log.d ( "Respuesta del servidor", response.body ().getMessage () );
                Log.d ( "Respuesta del servidor", " " + code );
                Log.d ( "INTENTANDO....", " "+ json );

                switch (code) {
                    case 200:

                        String message = response.body ().getMessage ();
                        String token = response.body ().getData ().getToken ();
                        String email = response.body ().getData ().getUser ().getEmail ();
                        String password = response.body ().getData ().getUser ().getPassword ();
                        Toast.makeText ( MainActivity.this, message, Toast.LENGTH_SHORT ).show ();
                        Log.d ( "200::", message );
                        Log.d ( "200::", token );
                        Log.d ( "200::", email );
                        Log.d ( "200::", password );

                        Log.d ( "Preferencias:", "guardando preferencias....." );

                        SharedPreferences.Editor editor = getSharedPreferences("userPrefs", MODE_PRIVATE).edit();
                        editor.putString("email", email);
                        editor.putString("pass", password);
                        editor.putString("token", token);
                        editor.apply();
                        Log.d ( "Preferencias:", "preferencias... guardadas" );

                        goToMenu ();

                        break;
                    case 400:

                        String errorMessage = response.body ().getMessage ();
                        Toast.makeText ( MainActivity.this, errorMessage, Toast.LENGTH_SHORT ).show ();
                    default:
                        String errrorMessage = response.body ().getMessage ();
                        Toast.makeText ( MainActivity.this, errrorMessage, Toast.LENGTH_SHORT ).show ();
                }

            }


            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

                Log.d ("Failture message", "FAILTUREEEEEEE CASEEEEEEEEEEEEEEEEEEE");
                String error = "Failtuure :algo ha salido mal al captar code 400:";
                Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
               // Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d ("Failture message",t.getMessage ().toString ());

            }

        });
    }

    private void goToMenu()
    {
        Intent intent = new Intent(this,MainMenuActivity.class);
        startActivity(intent);
    }


}
