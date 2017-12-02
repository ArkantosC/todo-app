package co.devhack.todoapp.presentation.view.fragment;


import android.os.Bundle;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment implements SignUpContract.View {

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

        tilEmailSignUp = view.findViewById(R.id.tilFullName);
        tilEmailSignUp = view.findViewById(R.id.tilPasswordSignUp);
        tilPasswordSignUp = view.findViewById(R.id.tilPasswordSignUp);
        btnRegister = view.findViewById(R.id.btnRegister);
        btnIhaveAccount = view.findViewById(R.id.btnIhaveAccount);


        return view;
    }

    @Override
    public void goToLoginFragment() {
        getChildFragmentManager().popBackStack();
    }

    @Override
    public void goToMainActivity() {

    }

    private void onSignUp() {
        try {

            boolean result = true;
            String fullName = tilFullName.getEditText().toString();
            String email = tilEmailSignUp.getEditText().toString();
            String password = tilPasswordSignUp.getEditText().toString();

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
                tilEmailSignUp.setEnabled(true);
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

}
