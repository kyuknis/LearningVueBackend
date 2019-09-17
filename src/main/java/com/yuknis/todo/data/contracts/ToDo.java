package com.yuknis.todo.data.contracts;

public interface ToDo {

    Long getId();

    void setId(Long id);

    String getTitle();

    void setTitle(String title);

    Boolean getComplete();

    void setComplete(Boolean complete);

    ToDoList getToDoList();

    void setToDoList(ToDoList toDoList);

}
