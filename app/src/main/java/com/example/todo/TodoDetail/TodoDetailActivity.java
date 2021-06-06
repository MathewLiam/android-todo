package com.example.todo.TodoDetail;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.todo.DTO.Models.Todo;
import com.example.todo.R;
import com.example.todo.TodoList.TodoListViewModel;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Defines the {@Link TodoDetailActivity} class for displaying todo details.
 */
public class TodoDetailActivity extends AppCompatActivity {
    /**
     * Defines the page title TextView element.
     */
    private TextView Title;

    /**
     * Defines the page description TextView element.
     */
    private TextView Description;

    /**
     * Method called on activity creation. Sets the view element text.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);
        Todo todo = (Todo) getIntent().getSerializableExtra("todo");

        Title = (TextView) findViewById(R.id.title_value);
        Description = (TextView) findViewById(R.id.description_value);

        Title.setText(todo.getTitle());
        Description.setText(todo.getDetail());
    }
}