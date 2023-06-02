package ru.mirea.sidorov_m.employeedb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MarvelSuperheroes {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public String superpower;
    public String team;
}