package com.example.vitormachado.mvparchitecture.shared.model;

import com.google.gson.annotations.SerializedName;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * @author vitor.machado on 12/06/18.
 */
@Entity
public class User {

    @Id(assignable = true)
    @SerializedName("id")
    private long id;
    @SerializedName("email") private String mail;
    @SerializedName("senha") private String password;
    private boolean isLogged;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String email) {
        this.mail = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }
}
