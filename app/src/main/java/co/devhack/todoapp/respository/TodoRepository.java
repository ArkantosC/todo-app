package co.devhack.todoapp.respository;

import java.util.List;

import co.devhack.todoapp.domain.model.Todo;

/**
 * Created by diegocortes on 12/6/17.
 */

public interface TodoRepository {
    Long insert(Todo todo);
    void update(Todo todo);
    void delete(Todo todo);
    List<Todo> getAll();
}
