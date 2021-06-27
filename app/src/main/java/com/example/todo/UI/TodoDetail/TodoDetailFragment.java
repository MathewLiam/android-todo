package com.example.todo.UI.TodoDetail;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.todo.DTO.Models.Todo;
import com.example.todo.R;
import com.example.todo.TodoFormActivity;
import com.example.todo.UI.TodoForm.TodoFormFragment;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TodoDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodoDetailFragment extends Fragment {
    /**
     * The title TextView element.
     */
    private TextView mTitle;

    /**
     * The description TextView element.
     */
    private TextView mDescription;

    /**
     * The delete button element.
     */
    private Button mDeleteButton;

    /**
     *
     */
    private Button mEditButton;

    /**
     * The detail view model.
     */
    private TodoDetailViewModel mViewModel;

    public TodoDetailFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment DetailFragment.
     */
    public static TodoDetailFragment newInstance() {
        return new TodoDetailFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(TodoDetailViewModel.class);
        // Gets the view elements to populate with the todo details.
        mTitle = (TextView) view.findViewById(R.id.title_value);
        mDescription = (TextView) view.findViewById(R.id.description_value);
        mDeleteButton = (Button) view.findViewById(R.id.button_delete);
        mEditButton = (Button) view.findViewById(R.id.button_edit);
        mViewModel.getTodo().observe(getViewLifecycleOwner(), new Observer<Todo>() {
            @Override
            public void onChanged(Todo todo) {
                mTitle.setText(todo.getTitle());
                mDescription.setText(todo.getDetail());

                mDeleteButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TodoDeleteConfirmationFragment taskAddFragment = TodoDeleteConfirmationFragment.newInstance();
                        assert getFragmentManager() != null;
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.detail_container, taskAddFragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                });

                mEditButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), TodoFormActivity.class);
                        intent.putExtra(TodoFormActivity.FORM_MODE_KEY, 1);
                        intent.putExtra(TodoFormActivity.FORM_TODO_KEY, todo);
                        v.getContext().startActivity(intent);
                    }
                });
            }
        });

        return view;
    }
}