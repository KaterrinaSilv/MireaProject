package ru.mirea.serebriakovaea.mireaproject;

import android.app.Application;

import androidx.room.Room;

import ru.mirea.serebriakovaea.mireaproject.workdata.AppDatabase;

public class App extends Application {
    public static App instance;
    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public static App getInstance(){
        return instance;
    }
    public AppDatabase getDatabase(){
        return database;
    }
}
