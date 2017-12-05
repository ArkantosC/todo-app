package co.devhack.todoapp.respository.impl;

import android.telecom.Call;

import co.devhack.todoapp.domain.model.User;
import co.devhack.todoapp.helpers.Callback;

/**
 * Created by diegocortes on 11/30/17.
 */

public interface UserRepository {

    void login(String email, String password, Callback<User> callback);
    void signUp(User user, Callback<User> callback);
    void recoverPassword(String email, Callback<User> callback);
}
