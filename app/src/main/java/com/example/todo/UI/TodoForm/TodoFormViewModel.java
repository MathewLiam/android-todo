package com.example.todo.UI.TodoForm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.todo.DAL.Repositories.TodoRepository;
import com.example.todo.DTO.Models.Todo;
import com.example.todo.Lookup.General;

import static com.example.todo.Lookup.General.FormMode;

/**
 * Defines the TodoFormViewModel to submit an update or insert.
 */
public class TodoFormViewModel extends AndroidViewModel {
    private FormMode FormMode;

    private Todo Todo;

    private TodoRepository TodoRepository;

    public TodoFormViewModel(@NonNull Application application) {
        super(application);
        TodoRepository = new TodoRepository(application);
    }

    public FormMode getFormMode() {
        return FormMode;
    }

    public void setFormMode(FormMode formMode) {
        this.FormMode = formMode;
    }

    public Todo getTodo() {
        return this.Todo;
    }

    public void setTodo(Todo todo) {
        this.Todo = todo;
    }

    public void Submit() {
        try {
            switch (FormMode) {
                case CREATE:
                    this.TodoRepository.Create(this.Todo);
                case EDIT:
                    this.TodoRepository.Update(this.Todo);
            }
        } catch (Exception ex) {
            // TODO: Add the catch logic here.
        }
    }

}
