package co.devhack.todoapp.presentation.presenter;

import co.devhack.todoapp.domain.model.User;
import co.devhack.todoapp.domain.usecase.UserUseCase;
import co.devhack.todoapp.domain.usecase.impl.UserUseCaseImpl;
import co.devhack.todoapp.helpers.Callback;

/**
 * Created by diegocortes on 11/30/17.
 */

public class LoginPresenter implements  LoginContract.UserActionListener {

    private LoginContract.View view;
    private UserUseCase userUseCase;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        this.userUseCase = new UserUseCaseImpl();
    }

    @Override
    public void onLogin(String email, String password, boolean remember) {
        userUseCase.login(email, password, remember, new Callback<User>() {
            @Override
            public void success(User user) {
                view.hideProgress();
                view.goToMainActivity();
            }

            @Override
            public void error(Exception error) {
                view.hideProgress();
                view.showMessageError(error);
            }
        });
    }
}
