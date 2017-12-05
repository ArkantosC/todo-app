package co.devhack.todoapp.domain.usecase.impl;

import co.devhack.todoapp.domain.model.User;
import co.devhack.todoapp.domain.usecase.UserUseCase;
import co.devhack.todoapp.helpers.Callback;
import co.devhack.todoapp.respository.impl.UserFirebaseRepository;
import co.devhack.todoapp.respository.impl.UserRepository;

/**
 * Created by diegocortes on 12/2/17.
 */

public class UserUseCaseImpl implements UserUseCase {

    private UserRepository userRepository;

    public UserUseCaseImpl() {
        this.userRepository = new UserFirebaseRepository();
    }

    @Override
    public void login(String email, String password, final boolean remember, final Callback<User> callback) {
        userRepository.login(email, password, new Callback<User>() {
            @Override
            public void success(User user) {
                if (user != null && remember) {
                    //TODO guardar email en sharedPreferences
                }
                callback.success(user);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }

    @Override
    public void signUp(String fullName, String email, String password, final Callback<User> callbakc) {

        User user = new User(fullName, email, password);

        userRepository.signUp(user, new Callback<User>() {
            @Override
            public void success(User user) {
                callbakc.success(user);
            }

            @Override
            public void error(Exception error) {
                callbakc.error(error);
            }
        });
    }

    @Override
    public void recoverPassword(String email, final Callback<Boolean> callback) {
        userRepository.recoverPassword(email, new Callback<Boolean>() {
            @Override
            public void success(Boolean result) {
                callback.success(true);
            }

            @Override
            public void error(Exception error) {
                callback.error(error);
            }
        });
    }
}
