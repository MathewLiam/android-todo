/**
 * @Author Mathew McPherson
 * @Date 04/06/2021
 */

package com.example.todo.DAL.Repositories;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.todo.DAL.DAO.TodoDao;
import com.example.todo.DTO.Database.TodoDatabase;
import com.example.todo.DTO.Models.Todo;

import java.util.List;
import java.util.UUID;

/**
 * Defines the TodoRepository for interactions with todo data.
 */
public class TodoRepository {

    private TodoDao TodoDao;

    /**
     * Constructs a new instance of the TodoRepository class.
     */
    public TodoRepository(Application application) {
        TodoDatabase db = TodoDatabase.getDatabase(application);
        this.TodoDao = db.todoDao();
    }

    public LiveData<List<Todo>> getAll() {
        return TodoDao.GetAll();
    }

    public LiveData<Todo> getByTitle(String title) {
        return TodoDao.Get(title);
    }

    public void Create(Todo todo) {
        try {
            TodoDao.Insert(todo);
        } catch (Exception ex) {
            Log.e(TodoRepository.class.getSimpleName(), "Failed to insert into the todo_table");
        }
    }
}