package com.yuknis.todo.data.mysql.repositories;

import com.yuknis.todo.data.mysql.models.ToDoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDoModel, Long> {
    List<ToDoModel> findByToDoListId(Long toDoListId);
}
