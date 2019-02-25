package com.example.alumnos.alumni.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password")
    @Expose
    private String password;


    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("birthday")
    @Expose
    private String birthday;

    @SerializedName("is_registered")
    @Expose
    private Integer is_registered;






    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getIs_registered() {
        return is_registered;
    }

    public void setIs_registered(Integer is_registered) {
        this.is_registered = is_registered;
    }
}
