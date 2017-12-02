package co.devhack.todoapp.helpers;

import co.devhack.todoapp.domain.model.User;

/**
 * Created by diegocortes on 12/2/17.
 */

public interface Callback<T> {

    void success(T result) ;
    void error(Exception e);

}
