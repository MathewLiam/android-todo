package com.example.todo.UI.TodoDetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.todo.DTO.Models.Todo;
import com.example.todo.R;
import android.os.Bundle;
import android.widget.TextView;

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
     * Defines the view model for the detail page.
     */
    private TodoDetailViewModel ViewModel;

    /**
     * Method called on activity creation. Sets the view element text.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);
        InitializeViewModel();
        
        // Gets the view elements to populate with the todo details.
        Title = (TextView) findViewById(R.id.title_value);
        Description = (TextView) findViewById(R.id.description_value);

        Title.setText(ViewModel.getTodo().getTitle());
        Description.setText(ViewModel.getTodo().getDetail());
    }

    /**
     * Method to initialize the view model for the todo details page.
     */
    private void InitializeViewModel() {
        ViewModel = new ViewModelProvider(this).get(TodoDetailViewModel.class);
        ViewModel.setTodo((Todo) getIntent().getSerializableExtra("todo"));
    }
}