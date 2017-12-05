package co.devhack.todoapp.presentation.presenter;

import co.devhack.todoapp.domain.model.User;
import co.devhack.todoapp.domain.usecase.UserUseCase;
import co.devhack.todoapp.domain.usecase.impl.UserUseCaseImpl;
import co.devhack.todoapp.helpers.Callback;

/**
 * Created by diegocortes on 12/4/17.
 */

public class RecoverPasswordPresenter implements RecoverPasswordContract.UserActionListener {

    private RecoverPasswordContract.View view;
    private UserUseCase userUseCase;

    public RecoverPasswordPresenter(RecoverPasswordContract.View view) {
        this.view = view;
        this.userUseCase = new UserUseCaseImpl();
    }

    @Override
    public void onRecoverPassword(String email) {

        userUseCase.recoverPassword(email, new Callback<Boolean>() {
            @Override
            public void success(Boolean result) {
                view.goToLoginFragment();
            }

            @Override
            public void error(Exception error) {
                view.showMessageError(error);
            }
        });

    }
}
