package br.com.tecapp.mvparchitecture.shared.service;

import br.com.tecapp.mvparchitecture.shared.model.User;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author vitor.machado on 12/06/18.
 */
public interface UserService {

    @POST("users/new")
    Single<User> createUser(@Body User user);

}
