package br.com.tecapp.mvparchitecture.shared.base;

import io.realm.Realm;

public interface BaseRepository {

    Realm getRealm();

    void detach();
}
