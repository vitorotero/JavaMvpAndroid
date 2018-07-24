package br.com.tecapp.mvparchitecture.shared.repository;

import br.com.tecapp.mvparchitecture.shared.base.BaseRepository;
import br.com.tecapp.mvparchitecture.shared.model.User;
import io.reactivex.Single;

/**
 * @author Vitor Otero on 12/06/18.
 */
public interface UserRepository extends BaseRepository {

    Single<User> getUserLogged();

    void saveUser(User user);

}
