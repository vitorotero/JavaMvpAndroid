package br.com.tecapp.mvparchitecture.shared.repository;

import br.com.tecapp.mvparchitecture.R;
import br.com.tecapp.mvparchitecture.shared.base.BaseRepositoryImp;
import br.com.tecapp.mvparchitecture.shared.exception.ObjectBoxException;
import br.com.tecapp.mvparchitecture.shared.model.User;
import io.reactivex.Single;
import io.realm.Realm;

import static br.com.tecapp.mvparchitecture.shared.model.User.PROPERTY_LOGGED;

/**
 * @author Vitor Otero on 12/06/18.
 */
public class UserRepositoryImp extends BaseRepositoryImp<Realm> implements UserRepository {

    public UserRepositoryImp(Realm realm) {
        super(realm);
    }

    @Override
    public Single<User> getUserLogged() {
        User userLogged = getRealm().where(User.class)
                .equalTo(PROPERTY_LOGGED, true)
                .findFirst();

        if (userLogged != null) {
            return Single.just(getRealm().copyFromRealm(userLogged));
        }

        return Single.error(new ObjectBoxException(R.string.user_not_found));
    }

    @Override
    public void saveUser(User user) {
        getRealm().executeTransaction(realm -> realm.copyToRealmOrUpdate(user));
    }
}
