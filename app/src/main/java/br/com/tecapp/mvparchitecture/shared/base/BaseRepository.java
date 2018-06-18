package br.com.tecapp.mvparchitecture.shared.base;


import io.objectbox.BoxStore;

public interface BaseRepository {

    BoxStore getBoxStore();

    void detach();
}
