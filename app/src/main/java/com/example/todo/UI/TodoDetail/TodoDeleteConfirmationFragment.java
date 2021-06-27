package com.example.todo.UI.TodoDetail;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.todo.DTO.Models.Todo;
import com.example.todo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TodoDeleteConfirmationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodoDeleteConfirmationFragment extends Fragment {

    /**
     *
     */
    private Button mButtonDelete;

    private TodoDetailViewModel mViewModel;

    public TodoDeleteConfirmationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment DeleteConfirmationFragment.
     */
    public static TodoDeleteConfirmationFragment newInstance() {
        return new TodoDeleteConfirmationFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_confirmation, container, false);
        mViewModel = new ViewModelProvider(requireActivity()).get(TodoDetailViewModel.class);
        mButtonDelete = (Button) view.findViewById(R.id.delete_confirm);

        mViewModel.getTodo().observe(getViewLifecycleOwner(), new Observer<Todo>() {
            @Override
            public void onChanged(Todo todo) {
                mButtonDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewModel.deleteTodo(todo);
                        getActivity().finish();
                    }
                });
            }
        });

        return view;
    }
}