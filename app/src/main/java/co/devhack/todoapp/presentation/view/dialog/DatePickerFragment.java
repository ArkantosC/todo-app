package co.devhack.todoapp.presentation.view.dialog;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import co.devhack.todoapp.R;
import co.devhack.todoapp.presentation.presenter.DatePickerContract;

/**
 * Created by diegocortes on 12/9/17.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerContract.View {

    private DatePicker dpFinishDate;


    public static DatePickerFragment getInstance() {
        return new DatePickerFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_date_picker, container, false);

        dpFinishDate = view.findViewById(R.id.dpFinishDate);

        return view;
    }

    @Override
    public void goToPreviousFragment() {
        Intent intent = new Intent();
        intent.putExtra("finishDate", "2017/12/11");
        getTargetFragment().onActivityResult(getTargetRequestCode(), 1, intent);
        getDialog().dismiss();
    }
}
