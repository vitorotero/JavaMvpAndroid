package com.example.vitormachado.testarchitecture.shared.manager;

import com.example.vitormachado.testarchitecture.shared.base.BaseManager;
import com.example.vitormachado.testarchitecture.shared.model.User;

/**
 * @author vitor.machado on 12/06/18.
 */
public interface UserManager extends BaseManager {

    User signIn(String user, String password);

}
