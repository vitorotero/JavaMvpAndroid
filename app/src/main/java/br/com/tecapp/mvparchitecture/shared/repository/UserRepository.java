package com.example.vitormachado.mvparchitecture.shared.repository;

import com.example.vitormachado.mvparchitecture.shared.base.BaseRepository;
import com.example.vitormachado.mvparchitecture.shared.model.User;

import io.reactivex.Single;

public interface UserRepository extends BaseRepository {

    Single<User> getUserLogged();

    void saveUser(User user);

}
