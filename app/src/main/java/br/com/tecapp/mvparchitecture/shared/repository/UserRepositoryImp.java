package br.com.tecapp.mvparchitecture.shared.repository;

import br.com.tecapp.mvparchitecture.R;
import br.com.tecapp.mvparchitecture.shared.base.BaseRepositoryImp;
import br.com.tecapp.mvparchitecture.shared.exception.ObjectBoxException;
import br.com.tecapp.mvparchitecture.shared.model.User;
import br.com.tecapp.mvparchitecture.shared.model.User_;

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
