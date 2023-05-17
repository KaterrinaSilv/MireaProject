package ru.mirea.serebriakovaea.mireaproject.workdata;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Client.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public ClientDao clientDao;
}
