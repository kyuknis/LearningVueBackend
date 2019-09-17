package com.yuknis.todo.data.dto;

import com.yuknis.todo.data.contracts.ToDo;
import com.yuknis.todo.data.contracts.ToDoList;

public class ToDoDTO implements ToDo {

    protected Long id;

    protected String title;

    protected Boolean complete;

    protected ToDoList toDoList;

    public ToDoDTO() {
        // ..
    }

    public ToDoDTO(Long id) {
        this.setId(id);
    }

    public ToDoDTO(String title, Boolean complete) {
        this.setTitle(title);
        this.setComplete(complete);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Boolean getComplete() {
        return complete;
    }

    @Override
    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    @Override
    public ToDoList getToDoList() {
        return toDoList;
    }

    @Override
    public void setToDoList(ToDoList toDoList) {

    }

}
