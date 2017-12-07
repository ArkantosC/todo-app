package co.devhack.todoapp.respository.impl;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import co.devhack.todoapp.database.AppDatabase;
import co.devhack.todoapp.domain.model.Todo;
import co.devhack.todoapp.respository.TodoRepository;

/**
 * Created by diegocortes on 12/6/17.
 */

public class TodoLocalRepository implements TodoRepository {

    @Dao
    public interface TodoDao {

        @Insert
        void insert(Todo todo);

        @Update
        void update(Todo todo);

        @Delete
        void delete(Todo todo);

        @Query("select * from todo")
        List<Todo> getAll();
    }



    @Override
    public void insert(Todo todo) {
        TodoDao todoDao = AppDatabase.getInstance().todoDao();
        todoDao.insert(todo);
    }

    @Override
    public void update(Todo todo) {
        TodoDao todoDao = AppDatabase.getInstance().todoDao();
        todoDao.update(todo);
    }

    @Override
    public void delete(Todo todo) {
        TodoDao todoDao = AppDatabase.getInstance().todoDao();
        todoDao.delete(todo);
    }

    @Override
    public List<Todo> getAll() {
        TodoDao todoDao = AppDatabase.getInstance().todoDao();
        return todoDao.getAll();
    }
}
