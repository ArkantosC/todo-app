package co.devhack.todoapp.presentation.presenter;

/**
 * Created by diegocortes on 11/30/17.
 */

public class AuthPresenter implements AuthContract.UserActionListener {

    private AuthContract.View view;

    public AuthPresenter(AuthContract.View view) {
        this.view = view;
    }

    @Override
    public void goToFirstFragment() {
        view.goToLoginFragment();

      //  view.goMainActivity();
    }
}
