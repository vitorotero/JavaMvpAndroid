package com.example.vitormachado.mvparchitecture.shared.base;


import io.objectbox.BoxStore;

public interface BaseRepository {

    BoxStore getBoxStore();

    void detach();
}
