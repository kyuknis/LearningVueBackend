package com.yuknis.todo.controllers;

import com.yuknis.todo.data.mysql.models.ToDoList;
import com.yuknis.todo.data.mysql.repositories.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/lists")
@CrossOrigin(origins = "*")
public class ToDoListController {

    @Autowired
    ToDoListRepository repository;

    @GetMapping
    public ResponseEntity<List<ToDoList>> index() {

        ResponseEntity<List<ToDoList>> response;

        List<ToDoList> lists = repository.findAll();
        response = new ResponseEntity<>(lists, HttpStatus.OK);

        return response;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ToDoList>> show(@PathVariable Long id) {

        ResponseEntity<Optional<ToDoList>> response;

        if(repository.existsById(id)) {

            Optional<ToDoList> record = repository.findById(id);
            response = new ResponseEntity<>(record, HttpStatus.OK);

        } else {

            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        return response;

    }

    @PostMapping
    public ResponseEntity<ToDoList> store(@RequestBody @Valid ToDoList toDoList) {

        ResponseEntity response;

        ToDoList storedToDo = repository.save(toDoList);
        response = new ResponseEntity<>(storedToDo, HttpStatus.CREATED);

        return response;

    }

    @DeleteMapping("{id}")
    public ResponseEntity destroy(@PathVariable Long id) {

        ResponseEntity response;

        if(repository.existsById(id)) {

            ToDoList model = new ToDoList();
            model.setId(id);
            repository.delete(model);

            response = new ResponseEntity(HttpStatus.OK);

        } else {

            response = new ResponseEntity(HttpStatus.NOT_FOUND);

        }

        return response;

    }

}
