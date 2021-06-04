package com.example.todo.DTO.Models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.UUID;

@Entity(tableName = "todo_table")
public class Todo {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "title")
    private String mTitle;
    private String mDetail;

    public Todo(@NonNull String title) {
        this.mTitle = title;
    }
    public String getTitle() {
        return this.mTitle;
    }

    public String getDetail() {
        return this.mDetail;
    }
    public void setDetail(String mDetail) {
        this.mDetail = mDetail;
    }

}