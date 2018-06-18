package com.example.vitormachado.testarchitecture.shared.manager;

import com.example.vitormachado.testarchitecture.shared.model.User;
import com.example.vitormachado.testarchitecture.shared.repository.UserRepository;
import com.example.vitormachado.testarchitecture.shared.service.UserService;

import io.reactivex.Single;

/**
 * @author vitor.machado on 12/06/18.
 */
public class UserManagerImp implements UserManager {

    private UserService userService;
    private UserRepository userRepository;

    public UserManagerImp(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public void detach() {
        userRepository.detach();
    }

    @Override
    public Single<User> doSignIn(String mail, String password) {
        return mockSignIn(mail, password);
    }

    @Override
    public Single<User> getUserLogged() {
        return userRepository.getUserLogged();
    }

    private void saveUser(User user) {
        userRepository.saveUser(user);
    }

    private Single<User> mockSignIn(String mail, String password) {
        User user = new User();
        user.setId(1);
        user.setMail(mail);
        user.setPassword(password);
        user.setLogged(true);

        saveUser(user);

        return Single.just(user);
    }
}
