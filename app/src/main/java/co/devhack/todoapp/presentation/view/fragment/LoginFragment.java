package co.devhack.todoapp.presentation.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import co.devhack.todoapp.R;
import co.devhack.todoapp.helpers.Utilities;
import co.devhack.todoapp.presentation.presenter.LoginContract;
import co.devhack.todoapp.presentation.presenter.LoginPresenter;
import co.devhack.todoapp.presentation.view.activity.AuthActivity;
import co.devhack.todoapp.presentation.view.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements LoginContract.View, View.OnClickListener {

    private LoginContract.UserActionListener mActionListener;
    private TextInputLayout tilEmail;
    private TextInputLayout tilPassword;
    private TextView tvForgotPassword;
    private Switch swRemember;
    private Button btnStart;
    private Button btnHasNotAccount;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment getInstance() {
        return new LoginFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        mActionListener = new LoginPresenter(this);

        tilEmail = view.findViewById(R.id.tilEmail);
        tilPassword = view.findViewById(R.id.tilPassword);
        tvForgotPassword = view.findViewById(R.id.tvForgotPassword);
        swRemember = view.findViewById(R.id.swRemember);
        btnStart = view.findViewById(R.id.btnStart);
        btnHasNotAccount = view.findViewById(R.id.btnHasNotAccount);

        btnStart.setOnClickListener(this);
        btnHasNotAccount.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);

        return view;
    }

    @Override
    public void goToSignUpFragment() {
        AuthActivity authActivity =  (AuthActivity) getActivity();
        authActivity.replaceFragment(SignUpFragment.getInstance(), true);
    }

    @Override
    public void goToMainActivity() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showMessageError(Exception error) {
        Snackbar.make(getView(), error.getMessage(), Snackbar.LENGTH_LONG).show();
    }

    public void goToRecoveryPassword() {
        RecoverPasswordFragment recoverPasswordFragment = RecoverPasswordFragment.getInstace();
        recoverPasswordFragment.show(getFragmentManager(), null);
    }

    private void onLogin() {
        try {
            boolean result = true;
            String email = tilEmail.getEditText().getText().toString();
            String password = tilPassword.getEditText().getText().toString();
            boolean remember = swRemember.isChecked();

            if (Utilities.isEmpty(email)) {
                tilEmail.setError(getString(R.string.is_required));
                tilEmail.setEnabled(true);
                result = false;
            } else {
                tilEmail.setError(null);
                tilEmail.setEnabled(false);
            }

            if (Utilities.isEmpty(password)) {
                tilPassword.setError(getString(R.string.is_required));
                tilPassword.setEnabled(true);
                result = false;
            } else {
                tilPassword.setError(null);
                tilPassword.setEnabled(false);
            }

            if (result) {
                mActionListener.onLogin(email, password, remember);
            }

        } catch (Exception e) {}
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                onLogin();
                break;
            case R.id.btnHasNotAccount:
                goToSignUpFragment();
                break;
            case R.id.tvForgotPassword:
                goToRecoveryPassword();
                break;
        }
    }
}
