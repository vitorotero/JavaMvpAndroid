package br.com.tecapp.mvparchitecture.shared.base;


import io.objectbox.BoxStore;

public class BaseRepositoryImp<B extends BoxStore> implements BaseRepository {

    private B boxStore;

    public BaseRepositoryImp(B boxStore) {
        this.boxStore = boxStore;
    }

    @Override
    public BoxStore getBoxStore() {
        return boxStore;
    }

    @Override
    public void detach() {
        boxStore.close();
    }
}
