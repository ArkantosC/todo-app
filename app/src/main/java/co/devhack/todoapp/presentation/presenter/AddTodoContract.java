package co.devhack.todoapp.presentation.presenter;

import java.util.Date;

/**
 * Created by diegocortes on 12/8/17.
 */

public interface AddTodoContract {

    interface View {
        void save();
        void goToViewTodoItem();
        void goToDatePickerFragment();
        void showErrorMessage(Exception error);
    }

    interface UserActionListener {
        void addTodo(String description, Date finishDate, boolean isFinish, String image, int color);
    }

}
