package com.example.todo.DTO.Models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.UUID;

@Entity(tableName = "todo_table")
public class Todo implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int Id;

    @NonNull
    @ColumnInfo(name = "title")
    private String mTitle;

    @ColumnInfo(name = "description")
    private String mDetail;

    public Todo(@NonNull String title) {
        this.mTitle = title;
    }
    public void setTitle(String title) {
        this.mTitle = title;
    }
    public String getTitle() {
        return this.mTitle;
    }
    public int getId() { return this.Id; }
    public void setId(int id) { this.Id = id; }
    public String getDetail() {
        return this.mDetail;
    }
    public void setDetail(String mDetail) {
        this.mDetail = mDetail;
    }

}