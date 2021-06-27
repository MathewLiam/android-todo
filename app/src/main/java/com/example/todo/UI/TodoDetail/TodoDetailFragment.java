package com.example.todo.UI.TodoDetail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.todo.DTO.Models.Todo;
import com.example.todo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TodoDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodoDetailFragment extends Fragment {

    private TextView mTitle;
    private TextView mDescription;
    private TodoDetailViewModel ViewModel;

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
        ViewModel = new ViewModelProvider(this).get(TodoDetailViewModel.class);
        ViewModel.setTodo((Todo) getActivity().getIntent().getSerializableExtra("todo"));
        // Gets the view elements to populate with the todo details.
        mTitle = (TextView) view.findViewById(R.id.title_value);
        mDescription = (TextView) view.findViewById(R.id.description_value);

        mTitle.setText(ViewModel.getTodo().getTitle());
        mDescription.setText(ViewModel.getTodo().getDetail());

        return view;
    }
}