package com.example.alumnos.alumni.Api;

import com.example.alumnos.alumni.Models.JsonResponse;

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
    Call<JsonResponse> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<JsonResponse> register(@Field("email") String email, @Field("password") String password);


    @FormUrlEncoded
    @POST("createevent")
    Call<JsonResponse> createEvent(@Field("title") String title, @Field("description") String description, @Field("id_type") int id_type, @Field("id_group[1]") int id_group, @Header("Authorization")String authHeader);


    @GET("eventsandroid")
    Call<JsonResponse> getEventsList(@Query("type") String type, @Header("Authorization")String authHeader);

    @FormUrlEncoded

    @POST("deleteevent")
    Call<JsonResponse> delete(@Field("id") Integer id, @Header("Authorization")String authHeader);

}
