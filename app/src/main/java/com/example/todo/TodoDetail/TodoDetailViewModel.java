package com.example.todo.TodoDetail;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.todo.DAL.Repositories.TodoRepository;
import com.example.todo.DTO.Models.Todo;

public class TodoDetailViewModel extends AndroidViewModel {

    private Todo Todo;

    public TodoDetailViewModel(@NonNull Application application) {
        super(application);
    }

    public Todo getTodo() {
        return this.Todo;
    }

    private void setTodo(Todo todo) {
        this.Todo = todo;
    }
}
