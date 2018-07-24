package br.com.tecapp.mvparchitecture.shared.base;

import io.realm.Realm;

/**
 * @author Vitor Otero on 12/06/18.
 */
public interface BaseRepository {

    Realm getRealm();

    void detach();
}
