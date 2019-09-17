package com.yuknis.todo.data.contracts;

import java.util.List;

public interface ToDoList {

    Long getId();

    void setId(Long id);

    String getTitle();

    void setTitle(String title);

    String getDescription();

    void setDescription(String description);

    List<ToDo> getToDos();

    void setToDos(List<ToDo> toDos);

}
