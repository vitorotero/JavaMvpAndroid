package com.example.vitormachado.testarchitecture.shared.base;

public interface BasePresenter {

    String getStringByResId(int id);

    String getStringByResId(int id, Object... args);

    void detachView();

}
