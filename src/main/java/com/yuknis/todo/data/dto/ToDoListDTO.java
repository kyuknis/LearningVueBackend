package com.yuknis.todo.data.dto;

import com.yuknis.todo.data.contracts.ToDo;
import com.yuknis.todo.data.contracts.ToDoList;

import java.util.List;

public class ToDoListDTO implements ToDoList {

    protected Long id;

    protected String title;

    protected String description;

    protected List<ToDo> toDos;

    public ToDoListDTO() {
        // ..
    }

    public ToDoListDTO(Long id) {
        this.setId(id);
    }

    public ToDoListDTO(String title, String description) {
        this.setTitle(title);
        this.setDescription(description);
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
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public List<ToDo> getToDos() {
        return toDos;
    }

    @Override
    public void setToDos(List<ToDo> toDos) {
        this.toDos = toDos;
    }

}
