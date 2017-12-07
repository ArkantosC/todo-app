package co.devhack.todoapp;

import android.app.Application;

import co.devhack.todoapp.database.AppDatabase;

/**
 * Created by diegocortes on 12/6/17.
 */

public class MyApplication extends Application {

    public void onCreate() {
        super.onCreate();

        AppDatabase.init(getApplicationContext());
    }

}
