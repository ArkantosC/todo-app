package co.devhack.todoapp.presentation.presenter;

/**
 * Created by diegocortes on 11/30/17.
 */

public class SignUpPresenter implements SignUpContract.UserActionListener {

    private SignUpContract.View view;

    public SignUpPresenter(SignUpContract.View view) {
        this.view = view;
    }

    @Override
    public void onSignUp(String fullName, String emial, String password) {

    }
}
