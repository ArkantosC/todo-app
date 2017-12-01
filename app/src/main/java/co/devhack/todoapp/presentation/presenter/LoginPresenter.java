package co.devhack.todoapp.presentation.presenter;

/**
 * Created by diegocortes on 11/30/17.
 */

public class LoginPresenter implements  LoginContract.UserActionListener {

    private LoginContract.View view;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void onLogin(String email, String password, boolean remember) {

    }
}
