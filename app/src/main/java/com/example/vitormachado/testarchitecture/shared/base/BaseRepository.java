package com.example.vitormachado.testarchitecture.shared.base;


import io.objectbox.BoxStore;

public interface BaseRepository {

    BoxStore getBoxStore();

    void detach();
}
