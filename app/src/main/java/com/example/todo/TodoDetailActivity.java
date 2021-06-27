package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.todo.DTO.Models.Todo;
import com.example.todo.R;
import com.example.todo.UI.Main.MainFragment;
import com.example.todo.UI.TodoDetail.TodoDetailFragment;
import com.example.todo.UI.TodoDetail.TodoDetailViewModel;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Defines the {@Link TodoDetailActivity} class for displaying todo details.
 */
public class TodoDetailActivity extends AppCompatActivity {
    public static final String DETAIL_TODO_ID = "DETAIL_TODO_ID";

    private TodoDetailViewModel mViewModel;

    /**
     * Method called on activity creation. Sets the view element text.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(TodoDetailViewModel.class);
        mViewModel.setTodo(this.getIntent().getIntExtra(DETAIL_TODO_ID, 0));
        setContentView(R.layout.activity_todo_detail);
        new ViewModelProvider(this).get(TodoDetailViewModel.class);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container, TodoDetailFragment.newInstance())
                    .commitNow();
        }
    }
}