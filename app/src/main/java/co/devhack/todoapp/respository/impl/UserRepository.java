package co.devhack.todoapp.respository.impl;

import co.devhack.todoapp.domain.model.User;

/**
 * Created by diegocortes on 11/30/17.
 */

public interface UserRepository {

    void login(String email, String password);
    void signUp(User user);
}
