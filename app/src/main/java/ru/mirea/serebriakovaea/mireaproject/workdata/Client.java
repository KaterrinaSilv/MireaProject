package ru.mirea.serebriakovaea.mireaproject.workdata;

import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Client {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public String telephone;
    public String email;
}

