package co.devhack.todoapp.presentation.presenter;

import java.util.List;

import co.devhack.todoapp.domain.model.Todo;

/**
 * Created by diegocortes on 12/6/17.
 */

public interface TodoListContract {

    interface View {
        void refreshTodos();
    }

    interface UserActionListener {

        void loadAll();

        List<Todo> getListTodos();

    }

}
