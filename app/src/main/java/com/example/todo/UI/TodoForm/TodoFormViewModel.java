package com.example.todo.UI.TodoForm;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.example.todo.DAL.Repositories.TodoRepository;
import com.example.todo.DTO.Models.Todo;

public class TodoFormViewModel extends AndroidViewModel {

    private Todo Todo;

    private TodoRepository TodoRepository;

    public TodoFormViewModel(Application application) {
        super(application);
        this.TodoRepository = new TodoRepository(application);
    }

    public Todo getTodo() {
        return this.Todo;
    }

    public void setTodo(Todo todo) {
        this.Todo = todo;
    }

    public void SaveTodo() {
        this.TodoRepository.Create(this.Todo);
    }
}