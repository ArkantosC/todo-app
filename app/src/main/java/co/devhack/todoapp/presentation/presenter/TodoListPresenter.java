package co.devhack.todoapp.presentation.presenter;

import java.util.List;

import co.devhack.todoapp.domain.model.Todo;
import co.devhack.todoapp.domain.usecase.TodoUseCase;
import co.devhack.todoapp.helpers.Callback;

/**
 * Created by diegocortes on 12/6/17.
 */

public class TodoListPresenter implements TodoListContract.UserActionListener
{
    private TodoUseCase todoUseCase;
    private List<Todo> listTodos;

    @Override
    public void loadAll() {

        todoUseCase.getAll(new Callback<List<Todo>>() {
            @Override
            public void success(List<Todo> result) {
                listTodos.clear();
                listTodos.addAll(result);
            }

            @Override
            public void error(Exception e) {
                //TODO show error
            }
        });
    }

    @Override
    public List<Todo> getListTodos() {
        return listTodos;
    }
}
