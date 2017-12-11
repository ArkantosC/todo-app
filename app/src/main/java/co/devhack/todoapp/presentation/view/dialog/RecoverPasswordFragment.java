package co.devhack.todoapp.presentation.view.dialog;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import co.devhack.todoapp.R;
import co.devhack.todoapp.helpers.Utilities;
import co.devhack.todoapp.presentation.presenter.RecoverPasswordContract;
import co.devhack.todoapp.presentation.presenter.RecoverPasswordPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecoverPasswordFragment extends DialogFragment implements RecoverPasswordContract.View, View.OnClickListener {

    private RecoverPasswordContract.UserActionListener mActionListener;
    private EditText etEmailRecoverPassword;
    private Button tvRecover;

    public RecoverPasswordFragment() {
        // Required empty public constructor
    }

    public static RecoverPasswordFragment getInstance() {
        return new RecoverPasswordFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recover_password, container, false);

        mActionListener = new RecoverPasswordPresenter(this);

        etEmailRecoverPassword = view.findViewById(R.id.etEmailRecoverPassword);
        tvRecover = view.findViewById(R.id.tvRecover);

        tvRecover.setOnClickListener(this);

        return view;
    }

    @Override
    public void goToLoginFragment() {
        getFragmentManager().popBackStack();

    }

    @Override
    public void showMessageError(Exception error) {
        Snackbar.make(getView(), error.getMessage(), Snackbar.LENGTH_LONG).show();
    }

    private void onRecoverPassword() {
        try {
            boolean result = true;

            String email = etEmailRecoverPassword.getText().toString();

            if (Utilities.isEmpty(email)) {
                etEmailRecoverPassword.setError("Es requerido");
                etEmailRecoverPassword.setEnabled(true);
            } else {
                etEmailRecoverPassword.setError(null);
                etEmailRecoverPassword.setEnabled(false);
            }

            if (result) {
                mActionListener.onRecoverPassword(email);
            }

        } catch (Exception e) {}
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvRecover:
                onRecoverPassword();
                break;
        }
    }
}
