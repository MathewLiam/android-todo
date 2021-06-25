package com.example.todo.UI.Main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.todo.R;
import com.example.todo.UI.AddTodo.CreateTodoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void StartCreateNewActivity(View view) {
        Intent intent = new Intent(view.getContext(), CreateTodoActivity.class);
        view.getContext().startActivity(intent);
    }
}