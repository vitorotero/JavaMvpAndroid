package com.example.vitormachado.testarchitecture.shared.basemvp;

public interface BasePresenter {

    String getStringByResId(int id);

    String getStringByResId(int id, Object... args);

    void detachView();

}
