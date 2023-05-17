package ru.mirea.serebriakovaea.mireaproject.workdata;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ClientDao {
    @Query("SELECT * FROM Client")
    List<Client> getAll();
    @Query("SELECT * FROM Client WHERE id = :id")
    Client getById(long id);
    @Insert
    void insert(Client client);
    @Update
    void update(Client client);
    @Delete
    void delete(Client client);
}
