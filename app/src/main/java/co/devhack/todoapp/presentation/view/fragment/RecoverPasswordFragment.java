package co.devhack.todoapp.presentation.view.fragment;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.devhack.todoapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecoverPasswordFragment extends DialogFragment {


    public RecoverPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recover_password, container, false);
        return view;
    }

    public static RecoverPasswordFragment getInstace() {
        return new RecoverPasswordFragment();
    }


}
