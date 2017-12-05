package co.devhack.todoapp.presentation.presenter;

/**
 * Created by diegocortes on 12/4/17.
 */

public interface RecoverPasswordContract {

    interface View {
        void goToLoginFragment();
        void showMessageError(Exception error);
    }

    interface UserActionListener {
        void onRecoverPassword(String email);
    }

}
