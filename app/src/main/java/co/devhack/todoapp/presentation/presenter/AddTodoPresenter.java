package co.devhack.todoapp.presentation.presenter;

import java.util.Date;

import co.devhack.todoapp.domain.model.Todo;
import co.devhack.todoapp.domain.usecase.TodoUseCase;
import co.devhack.todoapp.helpers.Callback;

/**
 * Created by diegocortes on 12/8/17.
 */

public class AddTodoPresenter implements AddTodoContract.UserActionListener {

    private AddTodoContract.View view;
    private TodoUseCase todoUseCase;

    public AddTodoPresenter(AddTodoContract.View view) {
        this.view = view;
    }

    @Override
    public void addTodo(String description, Date finishDate, boolean isFinish, String image, int color) {

        todoUseCase.insert(description, finishDate, isFinish, image, color, new Callback<Todo>() {
            @Override
            public void success(Todo result) {
                view.save();
                view.goToViewTodoItem();
            }

            @Override
            public void error(Exception e) {
                view.goToViewTodoItem();
            }
        });

    }
}
