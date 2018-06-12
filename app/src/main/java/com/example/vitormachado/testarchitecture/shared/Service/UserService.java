package com.example.vitormachado.testarchitecture.shared.Service;

import com.example.vitormachado.testarchitecture.shared.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author vitor.machado on 12/06/18.
 */
public interface UserService {

    @POST("users/new")
    Call<User> createUser(@Body User user);

}
