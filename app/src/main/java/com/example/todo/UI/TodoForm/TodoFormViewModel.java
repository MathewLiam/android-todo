package com.example.todo.UI.TodoForm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

/**
 * Defines the TodoFormViewModel to submit an update or insert.
 */
public class TodoFormViewModel extends AndroidViewModel {
    private Boolean mFormMode;

    public TodoFormViewModel(@NonNull Application application, Boolean formMode) {
        super(application);
    }
}
