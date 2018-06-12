package com.example.vitormachado.testarchitecture.shared.model;

import com.google.gson.annotations.SerializedName;

/**
 * @author vitor.machado on 12/06/18.
 */
public class User {

    @SerializedName("id") private long id;
    @SerializedName("email") private String mail;
    @SerializedName("senha") private String password;

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
}
