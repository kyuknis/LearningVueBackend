package com.yuknis.todo.data.mysql.repositories;

import com.yuknis.todo.data.mysql.models.ToDoListModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoListModel, Long> {
}
