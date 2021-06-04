package com.example.todo.TodoList;

import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.todo.DTO.Models.Todo;

import java.util.List;

import com.example.todo.R;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Todo}.
 * TODO: Replace the implementation with code for your data type.
 */
public class TodoListViewAdapter extends RecyclerView.Adapter<TodoListViewAdapter.ViewHolder> {

    private List<Todo> Todos;

    public final LayoutInflater Inflater;

    public TodoListViewAdapter(TodoFragment context) {
        this.Inflater = LayoutInflater.from(context.getContext());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = this.Inflater.inflate(R.layout.fragment_todo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = Todos.get(position);
        holder.mContentView.setText(Todos.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return this.Todos.size();
    }

    public void setTodos(List<Todo> todoList) {
        this.Todos = todoList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public Todo mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.title);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}