package com.example.vitormachado.testarchitecture.shared.repository;

import com.example.vitormachado.testarchitecture.R;
import com.example.vitormachado.testarchitecture.shared.base.BaseRepositoryImp;
import com.example.vitormachado.testarchitecture.shared.exception.ObjectBoxException;
import com.example.vitormachado.testarchitecture.shared.model.User;
import com.example.vitormachado.testarchitecture.shared.model.User_;

import io.objectbox.BoxStore;
import io.reactivex.Single;

public class UserRepositoryImp extends BaseRepositoryImp<BoxStore> implements UserRepository {

    public UserRepositoryImp(BoxStore boxStore) {
        super(boxStore);
    }

    @Override
    public Single<User> getUserLogged() {
        User userLogged = getBoxStore().boxFor(User.class)
                .query()
                .equal(User_.isLogged, true)
                .build()
                .findFirst();

        if (userLogged != null) {
            return Single.just(userLogged);
        }

        return Single.error(new ObjectBoxException(R.string.user_not_found));
    }

    @Override
    public void saveUser(User user) {
        getBoxStore().boxFor(User.class).put(user);
    }
}
