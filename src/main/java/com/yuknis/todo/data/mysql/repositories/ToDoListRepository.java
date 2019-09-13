package com.yuknis.todo.data.mysql.repositories;

import com.yuknis.todo.data.mysql.models.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
}
