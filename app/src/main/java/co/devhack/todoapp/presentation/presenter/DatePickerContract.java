package co.devhack.todoapp.presentation.presenter;

/**
 * Created by diegocortes on 12/10/17.
 */

public interface DatePickerContract {

    interface View {

        void goToPreviousFragment();

    }

    interface UserActionListener {

        void saveDateSelected();

    }

}
