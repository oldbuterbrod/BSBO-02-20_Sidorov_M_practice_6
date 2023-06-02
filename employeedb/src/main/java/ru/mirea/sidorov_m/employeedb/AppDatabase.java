package ru.mirea.sidorov_m.employeedb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MarvelSuperheroes.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MarvelDao employeeDao();
}