package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;

import com.example.todo.DTO.Models.Todo;
import com.example.todo.Lookup.General;
import com.example.todo.UI.TodoDetail.TodoDetailFragment;
import com.example.todo.UI.TodoForm.TodoFormFragment;
import com.example.todo.UI.TodoForm.TodoFormViewModel;

public class TodoFormActivity extends AppCompatActivity {
    public static final String FORM_MODE_KEY = "FORM_MODE";
    public static final String FORM_TODO_KEY = "FORM_TODO";

    /**
     * View model for the todo form.
     */
    private TodoFormViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        General.FormMode formMode = General.FormMode.values()[this.getIntent().getIntExtra(FORM_MODE_KEY, 0)];
        mViewModel = new ViewModelProvider(this).get(TodoFormViewModel.class);
        mViewModel.setFormMode(formMode);
        if (formMode == General.FormMode.EDIT) {
            mViewModel.setTodo((Todo) this.getIntent().getSerializableExtra(FORM_TODO_KEY));
        }
        setContentView(R.layout.activity_todo_form);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.form_container, TodoFormFragment.newInstance())
                    .commitNow();
        }
    }
}