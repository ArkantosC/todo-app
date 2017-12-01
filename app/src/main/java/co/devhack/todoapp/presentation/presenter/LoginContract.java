package co.devhack.todoapp.presentation.presenter;

/**
 * Created by diegocortes on 11/30/17.
 */

public interface LoginContract {

    interface View {
        void goToSignUpFragment();
        void goToMainActivity();
    }

    interface UserActionListener {
        void onLogin(String email, String password, boolean remember);
    }

}
