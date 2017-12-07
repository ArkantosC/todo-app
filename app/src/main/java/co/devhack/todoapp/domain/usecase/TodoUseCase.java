package co.devhack.todoapp.domain.usecase;

import android.telecom.Call;

import java.util.Date;
import java.util.List;

import co.devhack.todoapp.domain.model.Todo;
import co.devhack.todoapp.helpers.Callback;

/**
 * Created by diegocortes on 12/6/17.
 */

public interface TodoUseCase {

    void insert(String description, Date finishDate, boolean isFinished, String image, int color, Callback<Todo> callback);

    void update(Todo todo, Callback<Todo> callback);

    void delete(Todo todo, Callback<Boolean> callback);

    void getAll(Callback<List<Todo>> callback);

}
