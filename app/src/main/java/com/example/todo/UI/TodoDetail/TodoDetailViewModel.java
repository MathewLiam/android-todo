package com.example.todo.UI.TodoDetail;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todo.DAL.Repositories.TodoRepository;
import com.example.todo.DTO.Models.Todo;

public class TodoDetailViewModel extends AndroidViewModel {

    private LiveData<Todo> Todo;

    private TodoRepository TodoRepository;

    public TodoDetailViewModel(@NonNull Application application) {
        super(application);
        TodoRepository = new TodoRepository(application);
    }

    public LiveData<Todo> getTodo() {
        return this.Todo;
    }

    public void setTodo(int Id) {
        this.Todo = TodoRepository.getById(Id);
    }

    public void deleteTodo(Todo todo) {
        this.TodoRepository.Delete(todo);
    }
}
