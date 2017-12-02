package co.devhack.todoapp.presentation.presenter;

/**
 * Created by diegocortes on 11/30/17.
 */

public interface SignUpContract {

    interface View {
        void goToLoginFragment();

        void goToMainActivity();

        void showMessageError(Exception error);
    }

    interface UserActionListener {
        void onSignUp(String fullName, String emial, String password);
    }
}
