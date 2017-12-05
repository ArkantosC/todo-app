package co.devhack.todoapp.domain.usecase;

import co.devhack.todoapp.domain.model.User;
import co.devhack.todoapp.helpers.Callback;

/**
 * Created by diegocortes on 12/2/17.
 */

public interface UserUseCase {

    void login(String email, String password, boolean remember, Callback<User> callback);
    void signUp(String fullName, String email, String password, Callback<User> callbakc);
    void recoverPassword(String email, Callback<Boolean> callback);

}
