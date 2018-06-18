package com.example.vitormachado.mvparchitecture.shared.manager;

import com.example.vitormachado.mvparchitecture.shared.base.BaseManager;
import com.example.vitormachado.mvparchitecture.shared.model.User;

import io.reactivex.Single;

/**
 * @author vitor.machado on 12/06/18.
 */
public interface UserManager extends BaseManager {

    Single<User> doSignIn(String user, String password);

    Single<User> getUserLogged();
}
