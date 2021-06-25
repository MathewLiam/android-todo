package com.example.todo.UI.TodoForm;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.todo.DTO.Models.Todo;
import com.example.todo.R;

public class TodoFormFragment extends Fragment {

    private TodoFormViewModel mViewModel;

    private EditText mTitleTextField;

    private EditText mDescriptionTextField;

    public static TodoFormFragment newInstance() {
        return new TodoFormFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.todo_form_fragment, container, false);
    }

    public void SubmitForm(View view) {
        Todo toSave = new Todo(mTitleTextField.getText().toString());

        mViewModel.setTodo(toSave);mViewModel.SaveTodo();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTitleTextField = getView().findViewById(R.id.text_input_title);
        mDescriptionTextField = getView().findViewById(R.id.text_input_detail);
        mViewModel = new ViewModelProvider(this).get(TodoFormViewModel.class);
    }

}