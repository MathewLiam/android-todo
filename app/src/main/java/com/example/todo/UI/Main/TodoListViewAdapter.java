package com.example.todo.UI.Main;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.todo.DTO.Models.Todo;

import java.util.List;

import com.example.todo.R;
import com.example.todo.TodoDetailActivity;
import com.google.android.material.card.MaterialCardView;

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
        try {
            return this.Todos.size();
        } catch (NullPointerException ex) {
            return 0;
        }
    }

    public void setTodos(List<Todo> todoList) {
        this.Todos = todoList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public final MaterialCardView mCardView;
        public Todo mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.title);
            mCardView = (MaterialCardView) view.findViewById(R.id.card);
            mContentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), TodoDetailActivity.class);
                    intent.putExtra(TodoDetailActivity.DETAIL_TODO_ID, Todos.get(getAdapterPosition()).getId());
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}