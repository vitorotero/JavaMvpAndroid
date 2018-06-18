package com.example.vitormachado.testarchitecture.shared.repository;

import com.example.vitormachado.testarchitecture.shared.base.BaseRepository;
import com.example.vitormachado.testarchitecture.shared.model.User;

import io.reactivex.Single;

public interface UserRepository extends BaseRepository {

    Single<User> getUserLogged();

    void saveUser(User user);

}
