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

    public LiveData<Todo> getById(int id) {
        return TodoDao.Get(id);
    }

    public void Create(Todo todo) {
        try {
            TodoDatabase.databaseExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    TodoDao.Insert(todo);
                }
            });
        } catch (Exception ex) {
            Log.e(TodoRepository.class.getSimpleName(), "Failed to insert into the todo_table");
        }
    }

    public void Update(Todo todo) {
        try {
            TodoDatabase.databaseExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    TodoDao.Update(todo);
                }
            });
        } catch (Exception ex) {
            Log.e(TodoRepository.class.getSimpleName(), "Failed to update a record in the todo_table");
        }
    }

    public void Delete(Todo todo) {
        try {
            TodoDatabase.databaseExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    TodoDao.Delete(todo);
                }
            });
        } catch (Exception ex) {
            Log.e(TodoRepository.class.getSimpleName(), String.format("Failed to delete {0} from the todo_table. {1}", todo.getId(), ex));
        }
    }
}
