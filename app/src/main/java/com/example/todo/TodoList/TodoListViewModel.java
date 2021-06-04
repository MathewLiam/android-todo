package com.example.todo.TodoList;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todo.DAL.Repositories.TodoRepository;
import com.example.todo.DTO.Models.Todo;

import java.util.List;

public class TodoListViewModel extends AndroidViewModel {
    private TodoRepository Repository;

    public TodoListViewModel(@NonNull Application application) {
        super(application);
        Repository = new TodoRepository(application);
    }

    LiveData<List<Todo>> getTodos() {
        return this.Repository.getAll();
    }
}
