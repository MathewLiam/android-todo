package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import com.example.todo.UI.Main.MainFragment;
import com.example.todo.UI.Main.TodoViewModel;

/**
 * Defines the MainActivity class. View to show list of todos.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * The view model for the todos.
     */
    private TodoViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mViewModel = new ViewModelProvider(this).get(TodoViewModel.class);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}