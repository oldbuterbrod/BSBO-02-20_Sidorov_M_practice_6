package ru.mirea.sidorov_m.employeedb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MarvelDao {
    @Query("SELECT * FROM MarvelSuperheroes")
    List<MarvelSuperheroes> getAll();

    @Query("SELECT * FROM MarvelSuperheroes WHERE id = :id")
    MarvelSuperheroes getById(long id);

    @Insert
    void insert(MarvelSuperheroes marvelSuperheroes);

    @Update
    void update(MarvelSuperheroes marvelSuperheroes);

    @Delete
    void delete(MarvelSuperheroes marvelSuperheroes);
}
