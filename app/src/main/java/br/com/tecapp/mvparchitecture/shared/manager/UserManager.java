package br.com.tecapp.mvparchitecture.shared.manager;

import br.com.tecapp.mvparchitecture.shared.base.BaseManager;
import br.com.tecapp.mvparchitecture.shared.model.User;
import io.reactivex.Single;

/**
 * @author Vitor Otero on 12/06/18.
 */
public interface UserManager extends BaseManager {

    Single<User> doSignIn(String user, String password);

    Single<User> getUserLogged();
}
