package com.example.todo.UI.Main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todo.DAL.Repositories.TodoRepository;
import com.example.todo.DTO.Models.Todo;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {
    private final TodoRepository todoRepository;
    private LiveData<List<Todo>> LiveDataTodos;

    public TodoViewModel(@NonNull Application application) {
        super(application);

        todoRepository = new TodoRepository(application);
        LiveDataTodos = todoRepository.getAll();
    }

    public LiveData<List<Todo>> getLiveDataTodos() {
        return LiveDataTodos;
    }
}
