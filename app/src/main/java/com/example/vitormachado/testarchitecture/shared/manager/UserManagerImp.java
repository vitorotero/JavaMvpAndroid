package com.example.vitormachado.testarchitecture.shared.manager;

import com.example.vitormachado.testarchitecture.shared.Service.UserService;
import com.example.vitormachado.testarchitecture.shared.model.User;

import io.reactivex.Single;

/**
 * @author vitor.machado on 12/06/18.
 */
public class UserManagerImp implements UserManager {

    private UserService userService;

    public UserManagerImp(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void detach() {
    }

    @Override
    public Single<User> doSignIn(String mail, String password) {
        return mockSignIn(mail, password);
    }

    private Single<User> mockSignIn(String mail, String password) {
        User user = new User();
        user.setId(1);
        user.setMail(mail);
        user.setPassword(password);
        return Single.just(user);
    }
}
