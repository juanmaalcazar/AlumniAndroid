package com.example.alumnos.alumni.Api;

import com.example.alumnos.alumni.Models.JsonRespone;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiAlumni {

    @FormUrlEncoded

    @POST("login")
    Call<JsonRespone> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<JsonRespone> register(@Field("email") String email, @Field("password") String password);


    @FormUrlEncoded
    @POST("createevent")
    Call<String> createEvent(@Field("title") String title, @Field("description") String description, @Field("id_type") Integer id_type, @Field("id_group[1]") Integer id_group, @Header("Authorization")String authHeader);


    @GET("eventsandroid")
    Call<JsonRespone> getEventsList(@Query("type") String type, @Header("Authorization")String authHeader);

}
