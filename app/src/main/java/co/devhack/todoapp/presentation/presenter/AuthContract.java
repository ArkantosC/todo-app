package co.devhack.todoapp.presentation.presenter;

/**
 * Created by diegocortes on 11/30/17.
 */

public interface AuthContract {

    // It will implement Fragment and Activity
    interface View {
        void goToLoginFragment();
        void goMainActivity();
    }

    // It will implement to presenter
    interface  UserActionListener {
        void goToFirstFragment();
    }
}
