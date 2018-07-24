package br.com.tecapp.mvparchitecture.shared.base;

import io.realm.Realm;

/**
 * @author Vitor Otero on 12/06/18.
 */
public class BaseRepositoryImp<B extends Realm> implements BaseRepository {

    private B realm;

    public BaseRepositoryImp(B realm) {
        this.realm = realm;
    }

    @Override
    public Realm getRealm() {
        return realm;
    }

    @Override
    public void detach() {
        realm.close();
    }
}
