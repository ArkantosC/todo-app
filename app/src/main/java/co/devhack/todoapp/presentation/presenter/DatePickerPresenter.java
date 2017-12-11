package co.devhack.todoapp.presentation.presenter;

/**
 * Created by diegocortes on 12/10/17.
 */

public class DatePickerPresenter implements DatePickerContract.UserActionListener {

    DatePickerContract.View view;

    public DatePickerPresenter(DatePickerContract.View view) {
        this.view = view;
    }

    @Override
    public void saveDateSelected() {
        view.goToPreviousFragment();
    }
}
