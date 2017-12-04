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
import android.widget.TextView;

import org.w3c.dom.Text;

import co.devhack.todoapp.R;
import co.devhack.todoapp.helpers.Utilities;
import co.devhack.todoapp.presentation.presenter.LoginContract;
import co.devhack.todoapp.presentation.presenter.SignUpContract;
import co.devhack.todoapp.presentation.presenter.SignUpPresenter;
import co.devhack.todoapp.presentation.view.activity.AuthActivity;
import co.devhack.todoapp.presentation.view.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements SignUpContract.View, View.OnClickListener {

    private SignUpContract.UserActionListener mActionListener;
    private TextInputLayout tilFullName;
    private TextInputLayout tilEmailSignUp;
    private TextInputLayout tilPasswordSignUp;
    private Button btnRegister;
    private Button btnIhaveAccount;


    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment getInstance() {
        return new SignUpFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        mActionListener = new SignUpPresenter(this);

        tilFullName = view.findViewById(R.id.tilFullName);
        tilEmailSignUp = view.findViewById(R.id.tilEmailSignUp);
        tilPasswordSignUp = view.findViewById(R.id.tilPasswordSignUp);
        btnRegister = view.findViewById(R.id.btnRegister);
        btnIhaveAccount = view.findViewById(R.id.btnIhaveAccount);

        btnRegister.setOnClickListener(this);
        btnIhaveAccount.setOnClickListener(this);

        return view;
    }

    @Override
    public void goToLoginFragment() {
        getFragmentManager().popBackStack();
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

    private void onSignUp() {
        try {

            boolean result = true;
            String fullName = tilFullName.getEditText().getText().toString();
            String email = tilEmailSignUp.getEditText().getText().toString();
            String password = tilPasswordSignUp.getEditText().getText().toString();

            if (Utilities.isEmpty(fullName)) {
                tilFullName.setError("Es requerido");
                tilFullName.setEnabled(true);
                result = false;
            } else {
                tilFullName.setError(null);
                tilFullName.setEnabled(false);
            }

            if (Utilities.isEmpty(email)) {
                tilEmailSignUp.setError("Es requerido");
                tilEmailSignUp.setEnabled(true);
                result = false;
            } else {
                tilEmailSignUp.setError(null);
                tilEmailSignUp.setEnabled(false);
            }

            if (Utilities.isEmpty(password)) {
                tilPasswordSignUp.setError("Es requerido");
                tilPasswordSignUp.setEnabled(true);
                result = false;
            } else {
                tilPasswordSignUp.setError(null);
                tilPasswordSignUp.setEnabled(false);
            }

            if (result) {
                mActionListener.onSignUp(fullName, email, password);
            }
        } catch (Exception e) {}
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegister:
                onSignUp();
                break;
            case R.id.btnIhaveAccount:
                goToLoginFragment();
                break;
        }
    }
}
