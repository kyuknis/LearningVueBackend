package com.yuknis.todo.controllers;

import com.yuknis.todo.data.dto.ToDoListDTO;
import com.yuknis.todo.data.mysql.models.ToDoListModel;
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

    ToDoListModel.Builder toDoListModelBuilder = new ToDoListModel.Builder();

    @GetMapping
    public ResponseEntity<List<ToDoListModel>> index() {

        ResponseEntity<List<ToDoListModel>> response;

        List<ToDoListModel> lists = repository.findAll();
        response = new ResponseEntity<>(lists, HttpStatus.OK);

        return response;

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ToDoListModel>> show(@PathVariable Long id) {

        ResponseEntity<Optional<ToDoListModel>> response;

        if(repository.existsById(id)) {

            Optional<ToDoListModel> record = repository.findById(id);
            response = new ResponseEntity<>(record, HttpStatus.OK);

        } else {

            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        return response;

    }

    @PostMapping
    public ResponseEntity<ToDoListModel> store(@RequestBody @Valid ToDoListDTO toDoListModel) {

        ResponseEntity response;
        ToDoListModel persistentToDoListModel = toDoListModelBuilder.create(toDoListModel);

        ToDoListModel storedToDo = repository.save(persistentToDoListModel);
        response = new ResponseEntity<>(storedToDo, HttpStatus.CREATED);

        return response;

    }

    @DeleteMapping("{id}")
    public ResponseEntity destroy(@PathVariable Long id) {

        ResponseEntity response;

        if(repository.existsById(id)) {

            ToDoListModel model = new ToDoListModel();
            model.setId(id);
            repository.delete(model);

            response = new ResponseEntity(HttpStatus.OK);

        } else {

            response = new ResponseEntity(HttpStatus.NOT_FOUND);

        }

        return response;

    }

}
