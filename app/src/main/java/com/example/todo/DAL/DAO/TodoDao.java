package com.example.todo.DAL.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todo.DTO.Models.Todo;

import java.util.List;
import java.util.UUID;

@Dao
public interface TodoDao {
    @Query("SELECT * FROM todo_table")
    LiveData<List<Todo>> GetAll();

    @Query("SELECT * FROM todo_table WHERE id = :id")
    LiveData<Todo> Get(int id);

    @Insert
    void Insert(Todo todo);

    @Delete
    void Delete(Todo todo);

    @Update
    void Update(Todo todo);

    @Query("DELETE FROM todo_table")
    void deleteAll();
}
