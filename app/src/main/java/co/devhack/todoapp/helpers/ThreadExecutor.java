package co.devhack.todoapp.helpers;

import com.google.android.gms.tasks.Task;

/**
 * Created by diegocortes on 12/6/17.
 */

public class ThreadExecutor<T> {

    private Task<T> task;

    public ThreadExecutor(Task<T> task) {
        this.task = task;
    }

    public void execute() {

    }

    // it will be executed in background
    public interface Task<T> {

        T execute() throws Exception;
        void finish(Exception error, T result);

    }
}
