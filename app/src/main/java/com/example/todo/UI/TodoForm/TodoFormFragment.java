package com.example.todo.UI.TodoForm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.todo.DTO.Models.Todo;
import com.example.todo.Lookup.General;
import com.example.todo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TodoFormFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodoFormFragment extends Fragment {

    /**
     * The submit button - the function of this button will be determined by the form mode.
     */
    private Button mSubmitButton;

    private EditText mTitle;

    private EditText mDescription;

    private TodoFormViewModel mViewModel;

    public TodoFormFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment TodoFormFragment.
     */
    public static TodoFormFragment newInstance() {
        return new TodoFormFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_todo_form, container, false);
        mViewModel = new ViewModelProvider(getActivity()).get(TodoFormViewModel.class);
        mSubmitButton = view.findViewById(R.id.submit_button);
        mSubmitButton.setText(mViewModel.getFormMode().equals(General.FormMode.CREATE) ? "CREATE" : "SUBMIT");
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Todo todo = mViewModel.getTodo() != null ? mViewModel.getTodo() : new Todo(mTitle.getText().toString());
                todo.setDetail(mDescription.getText().toString());
                todo.setTitle(mTitle.getText().toString());
                mViewModel.setTodo(todo);
                mViewModel.Submit();
                getActivity().finish();
            }
        });

        mTitle = view.findViewById(R.id.title_field);
        mDescription = view.findViewById(R.id.description_field);
        if (mViewModel.getTodo() != null) {
            mTitle.setText(mViewModel.getTodo().getTitle());
            mDescription.setText(mViewModel.getTodo().getDetail());
        }

        return view;
    }
}